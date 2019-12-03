package m1.team2;

import dataproto.Dealer;

class ContentEditor {

    public final static ContentEditor INSTANCE = new ContentEditor();

    private ContentEditor() {}

    public void openEditor(Dealer dealer) {
        ContentEditorView view = new ContentEditorView(dealer);
        view.display();
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.setId("123");
        ContentEditor.INSTANCE.openEditor(dealer);
    }
}