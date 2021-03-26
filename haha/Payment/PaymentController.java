package Payment;

import Controller.DatabaseConnection;
import Controller.Date;

public class PaymentController {
	public Payment _makes;
	DatabaseConnection databaseConnection;

	public void addCardPayment(int aJobID) {
		Card card = new Card();

		String strPrice = databaseConnection.query(
				"SLELECT price FROM job WHERE JobID = " + aJobID
		);
		card.setAmount(Float.parseFloat(strPrice));
		card.setJobID(aJobID);
		card.setDateOfPayment(new Date());

		Date dateOFPayment = new Date(), expirayDate = new Date();
		String cardType = "";
		int digits = 0;
		card.setDigits(digits);
		card.setExpiryDate(expirayDate);
		card.setCardType(cardType);
		card.write();
	}

	public void addCashPayment(int aJobID) {
		Cash cash = new Cash();

		String strPrice = databaseConnection.query(
				"SLELECT price FROM job WHERE JobID = " + aJobID
		);
		cash.setAmount(Float.parseFloat(strPrice));
		cash.setJobID(aJobID);
		cash.setDateOfPayment(new Date());

		cash.write();
	}

	public PaymentController() {
	}
}