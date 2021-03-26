package Report;

import Controller.Date;

public interface ReportInterface {

	void generateShiftReport(Date adateOfShift);

	void generateIndividualReport(int aCustomerId, Date aStartDate, Date aEndDate);

	void generatePerformanceReport(int aUserId, Date aStartDate, Date aEndDate);
}