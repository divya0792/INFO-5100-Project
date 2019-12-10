package m1.DAO;

import dataproto.Dealer;
import dataproto.RichText;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConverter {
    private static final String DEALER_INSERT_PATTERN = "INSERT INTO Dealer " +
            "(EmailID, Phone, Password, head_info_id, foot_info_id, left_info_id, right_info_id) " +
            "VALUES " +
            "(%s , %s, %s, %s, %s, %s, %s)";

//    UPDATE table_name
//    SET column1 = value1, column2 = value2, ...
//    WHERE condition;
    private static final String DEALER_UPDATE_PATTERN = "UPDATE Dealer " +
        "set " +
        "EmailID = %s, " +
        "Phone = %s, " +
        "Password = %s, " +
        "head_info_id = %s, " +
        "foot_info_id = %s, " +
        "left_info_id = %s, " +
        "right_info_id = %s " +
        "WHERE " +
        "DealerId = %s";

    private static final String DEALER_CONTENT_UPDATE_PATTERN = "UPDATE Dealer " +
            "set " +
            "EmailID = %s, " +
            "Phone = %s, " +
            "Password = %s, " +
            "head_info_id = %s, " +
            "foot_info_id = %s, " +
            "left_info_id = %s, " +
            "right_info_id = %s " +
            "WHERE " +
            "DealerId = %s";

    public static Dealer toDealer(ResultSet resultSet) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setId(resultSet.getString("DealerID"));
        dealer.setEmailId(resultSet.getString("EmailID"));
        dealer.setPhone(resultSet.getString("Phone"));
        dealer.setPassword(resultSet.getString("Password"));

        dealer.setHeadInfoId(resultSet.getString("head_info_id"));
        dealer.setFootInfoId(resultSet.getString("foot_info_id"));
        dealer.setLeftInfoId(resultSet.getString("left_info_id"));
        dealer.setRightInfoId(resultSet.getString("right_info_id"));
        return dealer;
    }

    public static RichText toRichText(ResultSet resultSet) throws SQLException {
        RichText richText = new RichText();
        richText.setBold(resultSet.getBoolean("is_bold"));
        richText.setBold(resultSet.getBoolean("is_italic"));
        richText.setId(resultSet.getString("id"));
        if (resultSet.getString("font_size") != null) {
            richText.setFontSize(Integer.parseInt(resultSet.getString("id")));
        }
        richText.setFontColor(resultSet.getString("font_color"));
        richText.setBackgroundColor(resultSet.getString("back_color"));
        richText.setHtmlString(resultSet.getString("html_string"));
        richText.setPlainText(resultSet.getString("plain_text"));

        return richText;
    }

    public static String toInsertSql(Dealer dealer) {

    }
}
