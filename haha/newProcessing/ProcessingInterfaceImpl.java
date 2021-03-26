package newProcessing;

public class ProcessingInterfaceImpl implements ProcessingInterface {

    private ProcessingController processingController;

    @Override
    public void addJob() {
        processingController.addJob();
    }

    @Override
    public void updateJob() {
        processingController.updateJob();
    }

    @Override
    public void inspectJobQueue() {
        processingController.traverseJobs();
    }

    @Override
    public void getTaskByJobId(int aJobId) {

    }

    @Override
    public void getJobQueueByCustomerId(int aCustomerId) {

    }

    @Override
    public void getJobByCustomerId(int aCustomerId) {

    }

    public ProcessingInterfaceImpl() {
        processingController = new ProcessingController();
    }
}
