package m1.team3.login;

import javax.swing.SwingUtilities;

public class VMSApp {

	public static void main(String args[])
    {
        // Run in the EDT
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new VMSLoginFrame();
            }
        });
    }
}
