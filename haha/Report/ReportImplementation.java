package Report;

import Controller.Date;

public class ReportImplementation implements ReportInterface {

    private ReportController reportController = new ReportController();

    @Override
    public void generateShiftReport(Date adateOfShift) {
        reportController.createReport((byte) 1);
    }

    @Override
    public void generateIndividualReport(int aCustomerId, Date aStartDate, Date aEndDate) {
        reportController.createReport((byte) 2);
    }

    @Override
    public void generatePerformanceReport(int aUserId, Date aStartDate, Date aEndDate) {
        reportController.createReport((byte) 3);
    }

    public ReportImplementation() {
    }
}
