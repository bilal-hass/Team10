package Users;

import Processing.Processing_Interface;
import Discount.DiscountInterface;
import Payment.Payment_Interface;

public class OfficeManager extends User {
	public Processing_Interface _works_with;
	public DiscountInterface _manages;
	public Payment_Interface _manages;

	public void newJob() {
		throw new UnsupportedOperationException();
	}

	public void updateJobStatus() {
		throw new UnsupportedOperationException();
	}

	public void backupDatabase() {
		throw new UnsupportedOperationException();
	}

	public void recoverDatabase() {
		throw new UnsupportedOperationException();
	}

	public void addNewPayment() {
		throw new UnsupportedOperationException();
	}

	public void accessOverduePayments() {
		throw new UnsupportedOperationException();
	}

	public void addAgreedDiscount() {
		throw new UnsupportedOperationException();
	}

	public void changeCustomerStatus() {
		throw new UnsupportedOperationException();
	}

	public void createUser() {
		throw new UnsupportedOperationException();
	}

	public void removeUser() {
		throw new UnsupportedOperationException();
	}

	public void editUserDetails() {
		throw new UnsupportedOperationException();
	}
}