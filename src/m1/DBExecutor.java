package m1;

import dataproto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return table.get(dealer.getId());
    }

    public boolean submitContentChange(Dealer dealer, RichText header, RichText footer, RichText left, RichText right) {
        List<RichText> row = new ArrayList<>();
        row.add(header);
        row.add(footer);
        row.add(left);
        row.add(right);
        table.put(dealer.getId(), row);
        return true;
    }
}





