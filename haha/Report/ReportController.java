package Report;

import java.util.LinkedList;

import Controller.Date;
import Users.User;

class ReportController {

    private Report report;

    void createReport(byte type) {
        if (type == 1) {
            Date timeTaken, totalEffort, dateOfShift;
            timeTaken = new Date();
            totalEffort = new Date();
            dateOfShift = new Date();
            // initialise dates thru GUI

            Shift report = new Shift();
            report.setTimeTaken(timeTaken);
            report.setTotalEffort(totalEffort);
            report.setDateOfShift(dateOfShift);

        } else if (type == 2) {
            Performance report = new Performance();
            User user = new User();
            report.setStaff(user);

        } else if (type == 3) {
            Individual report = new Individual();
            int customerID = 0;
            Date start, end;
            start = new Date();
            end = new Date();

            report.setCustomerId(customerID);
            report.setStartDate(start);
            report.setEndDate(end);

        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
		report.generate();
        viewReport();
    }

//	public void deleteReport() {
//		_creates.remove(report);
//	}

    void viewReport() {
        for (String s : report._text.split(";")) {
            System.out.println(s);
        }
    }

    ReportController() {

    }
}