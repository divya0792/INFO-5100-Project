package m1;

import dataproto.*;


class DBExecutor {
    // use singleton
    // the only way to call api is like DBExecutor.INSTANCE.getContent();
    public static final INSTANCE = new DBExecutor();

    // prevent other class create instance
    private DBExecutor() {
        // init, connect DB
    }

    public List<RichText> getContent(Dealer dealer) {
        // TODO
        return null;
    }

    public boolean submitContentChange(Dealer dealer, RichText header, RichText footer, RichText left, RichText right) {
        // TODO
        return true;
    }
}