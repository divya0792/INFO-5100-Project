package m1;

import dataproto.*;
import m1.DAO.DealerContentDAO;
import m1.DAO.DealerContentDAOImpl;
import m1.team14.MainPage;
import m1.team2.DealerAllContent;

public class Main {
    public static void main(String args[]) {
        Dealer d1 = new Dealer();
        d1.setId("1");
        Dealer d2 = new Dealer();
        d2.setId("2");
        Dealer d3 = new Dealer();
        d3.setId("3");
        System.out.println("dealer 1: " + DealerContentDAOImpl.INSTANCE.getContents(d1));
        System.out.println("dealer 2: " + DealerContentDAOImpl.INSTANCE.getContents(d2));
        System.out.println("dealer 3: " + DealerContentDAOImpl.INSTANCE.getContents(d3));

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
        DealerAllContent content = new DealerAllContent(header, footer, left, right);
        DealerContentDAOImpl.INSTANCE.updateContents(d1, content);
        new MainPage();
    }
}
