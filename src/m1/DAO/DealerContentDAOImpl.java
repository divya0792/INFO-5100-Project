package m1.DAO;

import dataproto.Dealer;
import dataproto.RichText;
import m1.team2.DealerAllContent;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DealerContentDAOImpl implements DealerContentDAO {

    public static final DealerContentDAOImpl INSTANCE = new DealerContentDAOImpl();

    private Map<String, DealerAllContent> table;

    private DealerAllContent DEFAULT;

    private DealerContentDAOImpl() {
        table = new HashMap<>();
        String[] ids = {"u1", "u2", "u3", "u4", "u5", "u6", "u7", "u8"};
        Stream.of(ids).forEach(id -> table.put(id, mockData(id)));
        DEFAULT = new DealerAllContent(new RichText(), new RichText(), new RichText(), new RichText());
    }

    @Override
    public DealerAllContent getContents(Dealer dealer) {
        DealerAllContent allContent = table.getOrDefault(dealer.getId(), DEFAULT);
        return copy(allContent);
    }

    @Override
    public boolean updateContents(Dealer dealer, DealerAllContent dealerAllContent) {
        System.out.println("submit data");
        table.put(dealer.getId(), copy(dealerAllContent));
        return true;
    }



    private DealerAllContent mockData(String id) {
        RichText left = new RichText();
        left.setPlainText("I am " + id);
        left.setHtmlString("I am " + id);
        RichText right = new RichText();
        right.setPlainText("right");
        right.setHtmlString("right");
        RichText header = new RichText();
        header.setPlainText("header");
        header.setHtmlString("header");
        RichText footer = new RichText();
        footer.setPlainText("footer");
        footer.setHtmlString("footer");
        return new DealerAllContent(header, footer, left, right);
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
