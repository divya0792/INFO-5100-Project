package m2.CustomerUI;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {

    public BaseFrame() {
        create();


        //add(con);
        addListeners();
        makeItVisible();
    }

    public abstract void create();

    //public abstract void add(Container con);

    public abstract void addListeners();

    public void makeItVisible() {
        setSize(600, 600);
        setVisible(true);
    }

}

