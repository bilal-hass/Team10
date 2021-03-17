package Report;

import Controller.Date;

public interface ReportInterface {

	public void generateShiftReport(Date aDateOfShift);

	public void generateIndividualReport(integer aCustomerId, date aStartDate, date aEndDate);

	public void generatePerformanceReport(integer aUserId, date aStartDate, date aEndDate);
}