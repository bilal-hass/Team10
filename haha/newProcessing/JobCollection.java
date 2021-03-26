package newProcessing;

import java.util.ArrayList;

public class JobCollection {
    private Queue queue;

    void addJob() {
        Job job = new Job();
        job.taskTypeCollection.addTaskType();
        queue.add(job);
    }

    ArrayList<Job> traverseJobs() {
        return queue.jobArrayList;
    }

    public JobCollection() {
        queue = new Queue();
    }
}
