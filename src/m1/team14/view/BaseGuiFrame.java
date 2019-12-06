package m1.team14.view;

import javax.swing.*;
import java.awt.*;

public abstract class BaseGuiFrame extends JFrame {
    static final int WIDTH = 600;
    static final int HEIGHT = 800;

    // init
    public void init(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimension = toolkit.getScreenSize();
        int x = (screenDimension.width - WIDTH) / 2;
        int y = (screenDimension.height - HEIGHT) / 2;
        setBounds(x, y, WIDTH, HEIGHT);
        setTitle("Vehicle System");
    }

    // create components of this frame
    abstract public void create();

    // add components to the container
    abstract void add(Container container);

    // set the default attributes of the frame
    public void makeVisible(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public BaseGuiFrame(){
        init();
        create();
        Container container = getContentPane();
        add(container);
        makeVisible();
    }
}
