package m4.Team4;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {

	public BaseFrame() {
		create();
		Container con = getContentPane();
		add(con);
		addListeners();
		makeItVisible();
	}

	public abstract void create();

	public abstract void add(Container con);

	public abstract void addListeners();

	public void makeItVisible() {
		setSize(600, 600);
		setVisible(true);
	}

}
