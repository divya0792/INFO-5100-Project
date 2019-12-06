package m1;

import dataproto.*;

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

    private Map<String, List<RichText>> table;

    private List<RichText> DEFAULT;

    // prevent other class create instance
    private DBExecutor() {
        // init, connect DB
        table = new HashMap<>();
        String[] ids = {"u1", "u2", "u3", "u4", "u5", "u6", "u7", "u8"};
        Stream.of(ids).forEach(id -> table.put(id, mockData(id)));


        DEFAULT = new ArrayList<>();
        DEFAULT.add(new RichText());
        DEFAULT.add(new RichText());
        DEFAULT.add(new RichText());
        DEFAULT.add(new RichText());
    }

    private List<RichText> mockData(String id) {
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
        List<RichText> row = new ArrayList<>();
        row.add(header);
        row.add(left);
        row.add(right);
        row.add(footer);
        return row;
    }

    private void addNewItem(String id) {
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
      List<RichText> row = new ArrayList<>();
      row.add(header);
      row.add(left);
      row.add(right);
      row.add(footer);
      table.put(id, row);
    }

    // [top, left, right, bottom]
    public List<RichText> getContent(Dealer dealer) {
//        if (!table.containsKey(dealer.getId())) {
//          addNewItem(dealer.getId());
//        }

        List<RichText> l = table.getOrDefault(dealer.getId(), DEFAULT);
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
