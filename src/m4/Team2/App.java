package m4.Team2;

import javax.swing.*;

import dataproto.Dealer;

public class App {

	public App(Dealer dealer) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeadsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LeadsPage(dealer.getId()).setVisible(true));
    }

    public static void main(String[] args) {
			Dealer a = new Dealer("DEA0001", "sdf", "09238490");
    	new App(a);
    }

}
