package m1.DAO;

import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import dataproto.Dealer;
import dataproto.RichText;
import m1.team2.DealerAllContent;
import utils.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DealerContentDAOImpl implements DealerContentDAO {
    public static final DealerContentDAOImpl INSTANCE = new DealerContentDAOImpl();

    private DealerContentDAOImpl() {
        try {
            jdbc = JDBC.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException("failed to get dealer content database instance", e);
        }
    }

    private static final String GET_CONTENT_QUERY = "WITH ids AS (\n" +
            "SELECT head_info_id, foot_info_id, left_info_id, right_info_id FROM Dealer d WHERE d.DealerID = ?)\n" +
            "SELECT 'header' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.head_info_id\n" +
            "UNION ALL SELECT 'footer' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.foot_info_id\n" +
            "UNION ALL SELECT 'left' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.left_info_id\n" +
            "UNION ALL SELECT 'right' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.right_info_id";
    private static final String GET_DEALER_CONTENT_IDS
            = "SELECT head_info_id, foot_info_id, left_info_id, right_info_id FROM Dealer WHERE DealerID = ?";
    private static final String UPDATE_DEALER_CONTENT = "UPDATE DealerContent\n" +
            "SET html_string = ?, plain_text = ?, font_size = ?, is_bold = ?, is_italic = ?, back_color = ?, font_color = ?\n" +
            "WHERE id = ?";

    private JDBC jdbc;

    @Override
    public DealerAllContent getContents(Dealer dealer) {
        String dealerId = dealer.getId();
        RichText header = null, footer = null, left = null, right = null;
        try {
            ResultSet rs = jdbc.query(GET_CONTENT_QUERY, new String[]{dealerId});
            while (rs.next()) {
                RichText rt = new RichText();
                rt.setId(rs.getString("id"));
                rt.setHtmlString(rs.getString("html_string"));
                rt.setFontSize(rs.getInt("font_size"));
                rt.setPlainText(rs.getString("plain_text"));
                rt.setBold(rs.getBoolean("is_bold"));
                rt.setBold(rs.getBoolean("is_italic"));
                rt.setBackgroundColor(rs.getString("back_color"));
                rt.setFontColor(rs.getString("font_color"));
                switch (rs.getString("area")) {
                    case "header":
                        header = rt;
                        break;
                    case "footer":
                        footer = rt;
                        break;
                    case "left":
                        left = rt;
                        break;
                    case "right":
                        right = rt;
                        break;
                    default:
                        throw new RuntimeException("unknown dealer content type");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed to query dealer content", e);
        }
        return new DealerAllContent(header, footer, left, right);
    }

    @Override
    public boolean updateContents(Dealer dealer, DealerAllContent dealerAllContent) {
        String dealerId = dealer.getId();
        String headerId, footerId, leftId, rightId;
        try {
            ResultSet rs = jdbc.query(GET_DEALER_CONTENT_IDS, new String[]{dealerId});
            if (!rs.next()) {
                return false;
            }
            headerId = rs.getString("head_info_id");
            footerId = rs.getString("foot_info_id");
            leftId = rs.getString("left_info_id");
            rightId = rs.getString("right_info_id");
        } catch (SQLException e) {
            throw new RuntimeException("failed to query dealer content IDs", e);
        }
        try {
            updateDealerContent(headerId, dealerAllContent.getHeader());
            updateDealerContent(footerId, dealerAllContent.getFooter());
            updateDealerContent(leftId, dealerAllContent.getLeft());
            updateDealerContent(rightId, dealerAllContent.getRight());
        } catch (SQLException e) {
            throw new RuntimeException("failed to update dealer contents", e);
        }
        return true;
    }

    private void updateDealerContent(String id, RichText content) throws SQLException {
        if (jdbc.update(UPDATE_DEALER_CONTENT, new String[]{
                content.getHtmlString() == null ? "" : content.getHtmlString(),
                content.getPlainText() == null ? "" : content.getPlainText(),
                content.getFontSize() == null ? "" : Integer.toString(content.getFontSize()),
                Boolean.toString(content.isBold()),
                Boolean.toString(content.isItalic()),
                content.getBackgroundColor() == null ? "" : content.getBackgroundColor(),
                content.getFontColor() == null ? "" : content.getFontColor(),
                id}) != 1) {
            throw new RuntimeException("dealer content with ID " + id + " does not exist");
        }
    }

    public DealerAllContent copy(DealerAllContent input) {
        return new DealerAllContent(copy(input.getHeader()), copy(input.getFooter()), copy(input.getLeft()), copy(input.getRight()));
    }

    public RichText copy(RichText input) {
        RichText copy = new RichText();
        if (input == null) {
            return copy;
        }
        copy.setId(input.getId());
        copy.setFontColor(input.getFontColor());
        copy.setBackgroundColor(input.getBackgroundColor());
        copy.setHtmlString(input.getHtmlString());
        copy.setPlainText(input.getPlainText());
        copy.setFontSize(input.getFontSize());
        copy.setItalic(input.isItalic());
        copy.setBold(input.isBold());
        return copy;
    }
}
