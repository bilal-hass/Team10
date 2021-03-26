package newProcessing;

public interface ProcessingInterface {

    void addJob();

    void updateJob();

    void inspectJobQueue();

    void getTaskByJobId(int aJobId);

    void getJobQueueByCustomerId(int aCustomerId);

    void getJobByCustomerId(int aCustomerId);
}
