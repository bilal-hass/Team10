package Payment;

import Controller.Date;

public class Cash extends Payment {
    @Override
    public void write() {
        databaseConnection.query(
                "INSERT INTO cashPayment VALUES " +
                        String.format("%d, %s,",
                                getJobID(), _dateOfPayment.toString()
                        )
        );
        databaseConnection.query(
                "UPDATE jobs SET isPaid = true WHERE jobID = " + getJobID()
        );
    }
}