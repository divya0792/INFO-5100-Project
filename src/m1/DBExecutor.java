package m1;

import dataproto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DBExecutor {
    // use singleton
    // the only way to call api is like DBExecutor.INSTANCE.getContent();
    public static final DBExecutor INSTANCE = new DBExecutor();

    private Map<String, List<RichText>> table;

    // prevent other class create instance
    private DBExecutor() {
        // init, connect DB
        table = new HashMap<>();
        RichText left = new RichText();
        left.setPlainText("left");
        left.setHtmlString("left");
        RichText right = new RichText();
        right.setPlainText("right");
        right.setHtmlString("right");
        RichText header = new RichText();
        header.setPlainText("header");
        header.setHtmlString("header");
        RichText footer = new RichText();
        footer.setPlainText("footer");
        footer.setHtmlString("footer");
        List<RichText> row = new ArrayList<>();
        row.add(header);
        row.add(left);
        row.add(right);
        row.add(footer);
        table.put("ch", row);
    }

    // [top, left, right, bottom]
    public List<RichText> getContent(Dealer dealer) {
        if (!table.containsKey(dealer.getId())) {
            return null;
        }
        List<RichText> l = table.get(dealer.getId());
        return l.stream().map(this::copy).collect(Collectors.toList());
    }

    public boolean submitContentChange(Dealer dealer, RichText header, RichText footer, RichText left, RichText right) {
        System.out.println("submit data");
        List<RichText> row = new ArrayList<>();
        row.add(copy(header));
        row.add(copy(footer));
        row.add(copy(left));
        row.add(copy(right));
        table.put(dealer.getId(), row);
        return true;
    }

    public RichText copy(RichText input) {
        RichText copy = new RichText();
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





