package Payment;

import Controller.DatabaseConnection;

public class PaymentImplementation implements Payment_Interface {

	private PaymentController paymentController;
	DatabaseConnection databaseConnection = new DatabaseConnection();

	public void makePayement(int aJobId) {
		// gui to choose type
		paymentController.addCardPayment(aJobId);
		paymentController.addCashPayment(aJobId);
	}

	public int getJobById(int aCustomerId) {
		String[] strPrices = databaseConnection.query(
				"SELECT price FROM Job WHERE CustomerID = " + aCustomerId + "AND Paid == false"
		).split(";");
		return Integer.parseInt(strPrices[strPrices.length - 1]);
	}

	public int getCustomerById(int customerID) {
		String jobsStr = databaseConnection.query(
				"SELECT * FROM JOBS WHERE isPaid = false AND customerID = " + customerID
		);
		for (String s : jobsStr.split(";")) {
			System.out.println(s);
		}
		//select job
		int jobID = 0;
		return jobID;
	}

	public PaymentImplementation() {
		paymentController = new PaymentController();
	}
}