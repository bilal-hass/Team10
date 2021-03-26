package newProcessing;

import Controller.DatabaseConnection;
import Controller.Date;

class ProcessingController {

    //    List<Job> jobs = new ArrayList<>();
    private JobCollection jobs;

    void addJob() {
        jobs.addJob();
    }

    void updateJob() {
        Job toUpdate;
        for (Job job : jobs.traverseJobs()) {
            // gui to display jobs and select one
            toUpdate = job;
            toUpdate.taskTypeCollection.traverseTaskTypes();
        }

    }

    void traverseJobs() {
        for (Job job : jobs.traverseJobs()) {
            // gui to display jobs and select one
            System.out.println(job.getJobId());
        }
    }

    ProcessingController() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String[] jobsArr = databaseConnection.query(
                "SELECT * FROM job WHERE Completed = false"
        ).split(";");
        for (String s : jobsArr) {
            String[] splitS = s.split(",");
            Job job = new Job();
            job.setUrgency(new Date());
            job.setCustomerId(Integer.parseInt(splitS[1]));
            job.setConfirmedStatus(Boolean.parseBoolean(splitS[2]));
            job.setCompletedStatus(Boolean.parseBoolean(splitS[3]));
            job.setPaid(false);
        }
    }
}
