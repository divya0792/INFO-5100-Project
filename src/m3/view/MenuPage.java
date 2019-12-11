package m3.view;

import dataproto.Dealer;

import javax.swing.*;
import java.awt.*;

public class MenuPage extends BasicUI {


	private JButton IncentivePage, DealerDetailPage, VehiclePage, LeadsPage;
	private Dealer d;


	public MenuPage(Dealer d) {
		getDealer(d);
	}


	@Override
	public void create() {
		IncentivePage = new JButton("MyIncentive");
		DealerDetailPage = new JButton("MyInformation");
		VehiclePage = new JButton("MyVehicle");
		LeadsPage = new JButton("MyLeads");

		// TODO Auto-generated method stub

	}


	public void getDealer(Dealer d) {
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
		// TODO Auto-generated method stub
		IncentivePage.addActionListener(e -> {
			IncentiveListUI i = new IncentiveListUI(d);
		});

		DealerDetailPage.addActionListener(e -> {
			//DealerDetailpage d = new DealerDetailPage(d);
		});

		VehiclePage.addActionListener(e -> {
			//VehiclePage v = new VehiclePage(d);
		});

		LeadsPage.addActionListener(e -> {
			//LeadsPage l = new LeadsPage(d);
		});
	}

	public void makeItVisible() {
		setSize(500, 600);
		setVisible(true);
	}
}
