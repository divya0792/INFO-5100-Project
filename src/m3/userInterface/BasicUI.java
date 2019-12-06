package m3.userInterface;

import java.awt.Container;

import javax.swing.JFrame;

public abstract class BasicUI extends JFrame{
	
	public BasicUI() {
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
