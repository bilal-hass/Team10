package newProcessing;

import Controller.Date;

import java.util.ArrayList;

public class Queue extends ArrayList {

    ArrayList<Job> jobArrayList = new ArrayList<>();

    void add(Job job) {
        jobArrayList.add(job);
    }

    Job getNext() {
        Job next = jobArrayList.get(0);
        int leastTime = 1000000;
        int time;
        Date now = new Date();
        for (Job job : jobArrayList) {
            time = job.getUrgency().compareTo(now);
            if (time < leastTime && !job.isCompletedStatus()) {
                next = job;
            }
        }
        return next;
    }

}
