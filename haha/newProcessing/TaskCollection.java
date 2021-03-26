package newProcessing;

import Controller.Date;

import java.util.ArrayList;
import java.util.List;

public class TaskCollection {

    List<Task> tasks = new ArrayList<Task>();

    void addTask(Task task) {
        task.setStatus(0);
        task.setStartTime(new Date());
        //gui to add special instructions
        task.setSpecialInstructions("");
        tasks.add(task);
    }

    void updateTask() {
        for (Task task : tasks) {
            // gui to select task
            task.setStatus(task.getStatus()+1);
        }

    }

    }
