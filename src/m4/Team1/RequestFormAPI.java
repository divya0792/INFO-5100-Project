package m4.Team1;

import javax.swing.JFrame;

import m4.Team1.controller.RequestFormController;
import m4.Team1.database.dao.CustomerRequestTableDao;
import m4.Team1.database.dao.DealerTableDao;
import m4.Team1.database.dao.VehicleTableDao;
import m4.Team1.database.utils.Constants;

public class RequestFormAPI {

	public RequestFormAPI(String carID,String dealerID)
	{
		RequestFormController controller = new RequestFormController(
				new VehicleTableDao(Constants.sqlUrl, Constants.carTableName), new DealerTableDao(),
				new CustomerRequestTableDao(Constants.sqlUrl, Constants.customerRequestTableName));
		JFrame f = controller.createRequestForm(carID,dealerID);
		f.setTitle("Customer Request Form");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(600, 600);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RequestFormAPI("PIC2010760","0");

	}

}
