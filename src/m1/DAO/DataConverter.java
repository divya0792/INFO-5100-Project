package m1.DAO;

import dataproto.Dealer;
import dataproto.RichText;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConverter {


    public static Dealer toDealer(ResultSet resultSet) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setName(resultSet.getString("Name"));
        dealer.setId(resultSet.getString("id"));
        dealer.setEmailId(resultSet.getString("EmailID"));
        dealer.setPhone(resultSet.getString("Phone"));
        dealer.setPassword(resultSet.getString("Password"));
        dealer.setIconURL(resultSet.getString("icon_url"));
        dealer.setAddress(resultSet.getString("Address"));

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
}
