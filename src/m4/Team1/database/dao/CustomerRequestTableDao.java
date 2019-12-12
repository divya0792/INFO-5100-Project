package m4.Team1.database.dao;

import m4.Team1.database.model.CustomerInfo;
import m4.Team1.database.model.CustomerRequest;
import m4.Team1.database.utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRequestTableDao {
    private static final String LEAD_ID = "leadId";
    private static final String VEHICLE_ID = "vehicleId";
    private static final String DEALER_ID = "dealerId";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String CONTACT_NO = "contactNo";
    private static final String COMMENT = "comment";


    private final String url;
    private final String customerRequestTableName;

    private Connection connection;

    public CustomerRequestTableDao(String url, String customerRequestTableName) {
        this.url = url;
        this.customerRequestTableName = customerRequestTableName;
        connection = SQLUtil.getConnection(url);
    }

    public void writeCustomerRequest(CustomerRequest customerRequest) {
        try {
            if (connection.isClosed()) {
                connection = SQLUtil.getConnection(url);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            String writeSyntax = String.format("INSERT INTO dbo.%s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    customerRequestTableName, LEAD_ID, VEHICLE_ID, DEALER_ID, FIRST_NAME, LAST_NAME, EMAIL, CONTACT_NO, COMMENT,
                    customerRequest.getCustomerId(), customerRequest.getVehicleId(), customerRequest.getDealerId(),
                    customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getEmail(),
                    customerRequest.getContactNo(), SQLUtil.escape(customerRequest.getComment()));
            statement.executeUpdate(writeSyntax);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerInfo getCustomerInfo(String phoneNumberCleaned) {
        try {
            if (connection.isClosed()) {
                connection = SQLUtil.getConnection(url);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CustomerInfo customerInfo = new CustomerInfo();
        try (Statement statement = connection.createStatement()) {
            String selectSyntax = "SELECT firstName,lastName,email FROM dbo.CustomerRequest WHERE contactNo = '" + phoneNumberCleaned + "'";
            ResultSet customerAuto = statement.executeQuery(selectSyntax);
            while(customerAuto.next()){
                String fn = customerAuto.getString("firstName");
                String ln = customerAuto.getString("lastName");
                String em = customerAuto.getString("email");

                customerInfo.setPhoneNumber(phoneNumberCleaned);
                customerInfo.setEmail(em);
                customerInfo.setFirstName(fn);
                customerInfo.setLastName(ln);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerInfo;
    }





}
