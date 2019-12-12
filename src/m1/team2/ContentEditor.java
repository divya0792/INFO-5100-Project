package m1.team2;

import dataproto.Dealer;
import m1.DAO.DealerDAO;
import m1.DAO.DealerDAOImpl;

public class ContentEditor {

    public final static ContentEditor INSTANCE = new ContentEditor();

    private ContentEditor() {}

    public void openEditor(Dealer dealer) {
        System.out.println("input param " + dealer);
        ContentEditorView view = new ContentEditorView(dealer);
        view.display();
    }

    public static void main(String[] args) {
        Dealer dealer = DealerDAOImpl.INSTANCE.getDealerWithName("Rita").get();
        ContentEditor.INSTANCE.openEditor(dealer);
    }
}
