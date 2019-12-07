package m1.team2;

import dataproto.RichText;

public class DealerAllContent {
    RichText header;
    RichText footer;
    RichText left;
    RichText right;

    public DealerAllContent(RichText header, RichText footer, RichText left, RichText right) {
        this.header = header;
        this.footer = footer;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "DealerAllContent{" +
                "header=" + header +
                ", footer=" + footer +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public RichText getHeader() {
        return header;
    }

    public void setHeader(RichText header) {
        this.header = header;
    }

    public RichText getFooter() {
        return footer;
    }

    public void setFooter(RichText footer) {
        this.footer = footer;
    }

    public RichText getLeft() {
        return left;
    }

    public void setLeft(RichText left) {
        this.left = left;
    }

    public RichText getRight() {
        return right;
    }

    public void setRight(RichText right) {
        this.right = right;
    }
}
