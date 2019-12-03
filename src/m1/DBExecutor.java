package m1;

import dataproto.*;

import java.util.List;


public class DBExecutor {
    // use singleton
    // the only way to call api is like DBExecutor.INSTANCE.getContent();
    public static final DBExecutor INSTANCE = new DBExecutor();

    // prevent other class create instance
    private DBExecutor() {
        // init, connect DB
    }
 // [top, left, right, bottom]
    public List<RichText> getContent(Dealer dealer) {
        // TODO
        return null;
    }

    public boolean submitContentChange(Dealer dealer, RichText header, RichText footer, RichText left, RichText right) {
        // TODO
        return true;
    }
}





