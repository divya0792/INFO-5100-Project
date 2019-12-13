package m3.view;

import dataproto.Dealer;

import m1.team2.ContentEditor;
import m4.Team2.App;
import javax.swing.*;
import java.awt.*;
import m2.DealerUI.UI;

public class MenuPage extends BasicUI {
  private static final long serialVersionUID = 4L;

	private JButton IncentivePage, DealerDetailPage, VehiclePage, LeadsPage;
	private Dealer d;


	public MenuPage(Dealer d) {
		setDealer(d);
	}


	@Override
	public void create() {
		IncentivePage = new JButton("MyIncentive");
		DealerDetailPage = new JButton("MyInformation");
		VehiclePage = new JButton("MyVehicle");
		LeadsPage = new JButton("MyLeads");
	}


	public void setDealer(Dealer d) {
		this.d = d;
	}

	@Override
	public void add(Container con) {

		GridLayout gl = new GridLayout(0, 1);
		con.setLayout(gl);
		con.add(IncentivePage);
		con.add(DealerDetailPage);
		con.add(VehiclePage);
		con.add(LeadsPage);

	}

	@Override
	public void addListeners() {
		IncentivePage.addActionListener(e -> {
			IncentiveListUI i = new IncentiveListUI(d);
		});

		DealerDetailPage.addActionListener(e -> {
			ContentEditor.INSTANCE.openEditor(d);
		});

		VehiclePage.addActionListener(e -> {
			new UI(d);
		});

		LeadsPage.addActionListener(e -> {
      new App(d);
		});
	}

	public void makeItVisible() {
		setSize(500, 600);
		setVisible(true);
	}
}
