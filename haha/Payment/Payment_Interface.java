package Payment;

interface Payment_Interface {

	void makePayement(int aJobId);

	int getJobById(int aCustomerId);

	int getCustomerById(int customerID);
}