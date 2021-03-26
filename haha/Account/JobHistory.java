package Account;

import Controller.DatabaseConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobHistory {

	private List<String> history = new ArrayList<>();

	List<String> getJobsFromDatabase(int CustomerID) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		String jobs = databaseConnection.query(
				"SELECT * FROM job " +
						"INNER JOIN Customer_job ON job.ID = Customer_job.JobID " +
						"WHERE Customer_job.CustomerAccountNo = " + CustomerID
		);
		history = Arrays.asList(jobs.split(","));
		return history;
	}

	void editJobHistory(int CustomerID) {
		if (history.isEmpty()) getJobsFromDatabase(CustomerID);
		// GUI to select job
	}

	JobHistory() {
	}
}