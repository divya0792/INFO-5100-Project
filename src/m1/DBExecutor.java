package m1;

import dataproto.*;
import m1.team2.DealerAllContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DBExecutor {
    // use singleton
    // the only way to call api is like DBExecutor.INSTANCE.getContent();
    public static final DBExecutor INSTANCE = new DBExecutor();

    private Map<String, DealerAllContent> table;

    private DealerAllContent DEFAULT;

    // prevent other class create instance
    private DBExecutor() {
        // init, connect DB
        table = new HashMap<>();
        String[] ids = {"u1", "u2", "u3", "u4", "u5", "u6", "u7", "u8"};
        Stream.of(ids).forEach(id -> table.put(id, mockData(id)));

        DEFAULT = new DealerAllContent(new RichText(), new RichText(), new RichText(), new RichText());
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

    // [top, left, right, bottom]
    public DealerAllContent getContent(Dealer dealer) {
//        if (!table.containsKey(dealer.getId())) {
//          addNewItem(dealer.getId());
//        }

        DealerAllContent allContent = table.getOrDefault(dealer.getId(), DEFAULT);
        return copy(allContent);
    }

    public boolean submitContentChange(Dealer dealer, RichText header, RichText footer, RichText left, RichText right) {
        System.out.println("submit data");
        table.put(dealer.getId(), new DealerAllContent(copy(header), copy(footer), copy(left), copy(right)));
        return true;
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
