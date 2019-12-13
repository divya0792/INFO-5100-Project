package m3.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import m3.model.Incentive;
import m3.model.filter.Filter;
import m3.model.offer.Offer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableOperations {

    private Connection connection;

    public TableOperations() {
        CreateConnection();
    }

    public void CreateConnection() {
        //The connectionURL should be modified according to your own server.
        try {
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String connectionUrl = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433;databaseName=IncentiveManagementDB;user=INFO6210;password=NEUHusky!";
        try {
            // Load SQL Server JDBC driver and establish connection.
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connect successfully.");
            String sql = new StringBuilder().append("if not exists (select * from sysobjects where name='Incentive' and xtype='U')").
                    append("create table Incentive (").append("IncentiveID INT IDENTITY(1,1) primary key,").append("startDate DATETIME,").append("endDate DATETIME,").
                    append("Title VARCHAR(max),").append("Disclaimer VARCHAR(max),").append("FilterList VARCHAR(max),").append("Offer VARCHAR(max), dealerID VARCHAR(max))").toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    //Create a new line in a table, if table doesn't exist, create table first.
    /*

    if not exists (select * from sysobjects where name='[DealerName]' and xtype='U')
    create table [I.DealerName]] (
        IncentiveID INT IDENTITY(1,1) primary key,
        startDate DATETIME,
        endDate DATETIME,
        Title VARCHAR(max),
        Disclaimer VARCHAR(max),
        DealerID VARCHAR(max),
        FilterList(Convert to String) VARCHAR(max),
        Offer(Convert to String) VARCHAR(max)
        )

        INSERT INTO [DealerName] (startDate,endDate,Title,Disclaimer,DealerID,FilterList,Offer)

        VALUES (
            [I.getStartDate],[I.getEndDate],
            [I.getTitle],[I.getDisclaimer],[DealerName],
            [I.getFilterList(Convert to String)],
            [I.getOffer(Convert to String)]
        )

     */
    public void Create(Incentive I) {
        String filterList = null;
        String offer = null;
        try {
            filterList = DataFormatConversion.FilterToString(I);
            offer = DataFormatConversion.OfferToString(I);
        } catch (Exception e) {

            e.printStackTrace();
        }

        Date startDate = DateToSqlDatetime.JavaStartDateToSqlDate(I);
        Date endDate = DateToSqlDatetime.JavaEndDateToSqlDate(I);

        String sql = new StringBuilder().append("INSERT INTO Incentive").
                append(" (startDate,endDate,Title,Disclaimer,FilterList,Offer,dealerID) ").append("VALUES ('").
                append(startDate).append("','").append(endDate).append("','").append(I.getTitle()).append("','").append(I.getDisclaimer()).
                append("','").append(filterList).append("','").append(offer).append("','").append(I.getDealerID()).append("')").toString();
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("Create successfully.");
    }

    //Edit a item
    /*

        UPDATE [DealerID]
        SET startDate = '[I.getStartDate(convert to sql format)]',
        endDate = '[I.getEndDate(convert to sql format)]',
        Title = '[I.getTitle()]',
        Disclaimer = '[I.getDisclaimer()]',
        FilterList = '[I.getFilterList(Convert to String)]',
        Offer = '[I.getOffer(Convert to String)]'
        WHERE IncentiveID = '[I.getIncentiveID()]';

    * */

    public void EditItem(Incentive I) {
        // convert format
        String filterList = null;
        String offer = null;
        try {
            filterList = DataFormatConversion.FilterToString(I);
            offer = DataFormatConversion.OfferToString(I);
        } catch (Exception e) {

            e.printStackTrace();
        }

        Date startDate = DateToSqlDatetime.JavaStartDateToSqlDate(I);
        Date endDate = DateToSqlDatetime.JavaEndDateToSqlDate(I);

        String sql = new StringBuilder().append("UPDATE Incentive").
                append(" SET startDate='" + startDate + "', endDate='" + endDate
                        + "', Title='" + I.getTitle() + "', Disclaimer='" + I.getDisclaimer()
                        + "', FilterList='" + filterList + "', Offer='" + offer + "', dealerID='" + I.getDealerID() + "'").
                append("WHERE IncentiveID=" + I.getIncentiveID()).toString();
        System.out.println(sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //delete a item
    /*

        DELETE FROM [DealerID] WHERE IncentiveID = [I.IncentiveID];

    * */
    public void DeleteItem(Incentive I) {
        CreateConnection();
        String sql = new StringBuilder().append("DELETE FROM  Incentive").append(" WHERE IncentiveID = '" + I.getIncentiveID() + "';").toString();
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get list of incentives by DealerName
    /*
        SELECT * FROM [DealerID]

    * */
    public List<Incentive> getIncentiveByDealer(String dealerID) {
        List<Incentive> incentives = new ArrayList<>();
        String sql = "SELECT * FROM Incentive WHERE dealerID='" + dealerID + "'";
        System.out.println(sql);
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Incentive i = new Incentive();
                i.setIncentiveID(rs.getString("IncentiveID"));
                System.out.println(rs.getDate("startDate"));
                java.util.Date utilStartDate = rs.getDate("startDate");
                i.setStartDate(utilStartDate);
                java.util.Date utilEndDate = rs.getDate("endDate");
                i.setEndDate(utilEndDate);
                i.setTitle(rs.getString("Title"));
                i.setDisclaimer(rs.getString("Disclaimer"));
                ObjectMapper mapper = new ObjectMapper();
                List<Filter> filters = DataFormatConversion.stringToList(rs.getString("FilterList"));
                i.setConditions(filters); // JSON -> List<Filter>
                Offer offer = mapper.readValue(rs.getString("Offer"), Offer.class);
                i.setOffer(offer); // JSON -> Offer
                i.setDealerID(rs.getString("dealerID"));
                incentives.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incentives;
    }

}
