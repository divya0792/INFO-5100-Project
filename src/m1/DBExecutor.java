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
        RichText right = new RichText();
        left.setPlainText("right");
        RichText header = new RichText();
        left.setPlainText("header");
        RichText footer = new RichText();
        left.setPlainText("footer");
        List<RichText> row = new ArrayList<>();
        row.add(header);
        row.add(footer);
        row.add(left);
        row.add(right);
        table.put("ch", row);
    }

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





