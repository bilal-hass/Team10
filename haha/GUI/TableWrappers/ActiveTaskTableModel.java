package GUI.TableWrappers;

import GUI.DynamicTableModel;
import Processing.Job;
import Processing.Task;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

class TaskJobWrapper {
    private Task task;
    private Job job;
    public TaskJobWrapper(Job j, Task t) {
        job = j;
        task = t;
    }
    public Task getTask() {
        return task;
    }
    public Job getJob() {
        return job;
    }
    public String getTaskName() {
        return task.getName();
    }
    public long getRemainingTime() {
        return job.getRemainingTime();
    }
    private String getDurationBreakdown(long millis) {
        Boolean neg = millis < 0;
        millis = Math.abs(millis);

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(String.format("%02d", days));
        sb.append("d:");
        sb.append(String.format("%02d", hours));
        sb.append("h:");
        sb.append(String.format("%02d", minutes));
        sb.append("m:");
        sb.append(String.format("%02d", seconds));
        sb.append("s");

        return( (neg ? "-" : "") + sb.toString());
    }
    public String getColumnValue(Integer i) {
        switch (i) {
            case 0:

                long milliseconds = getRemainingTime();
                return getDurationBreakdown(milliseconds);
            case 1:
                return getTaskName();
            case 2:
                return job.getId().toString();
            case 3:
                return task.getLocation();
            case 4:
                return task.started() ? "■" : "□";
            default:
                return "bad column";
        }
    }
}

public class ActiveTaskTableModel extends DynamicTableModel {
    private final ArrayList<TaskJobWrapper> tasks = new ArrayList<>();
    private final ArrayList<TaskJobWrapper> filteredtasks = new ArrayList<>();
    private static String[] columns = {"Time Remaining", "Task Name", "Job ID", "Location", "Started"};
    public String _filter;

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public int getRowCount() {
        return filteredtasks.size();
    }

    @Override
    public String getValueAt(int row, int col) {
        return filteredtasks.get(row).getColumnValue(col);
    }

    public ActiveTaskTableModel() {
        _filter = "";
    }

    public Task getTaskAt(int row) {
        return filteredtasks.get(row).getTask();
    }

    public Job getJobAt(int row) {
        return filteredtasks.get(row).getJob();
    }

    public void removeByTask(Task t) {
        ArrayList<TaskJobWrapper> matches = new ArrayList<>();
        for (TaskJobWrapper wrap: tasks) {
            if (wrap.getTask().getId().equals(t.getId())) {
                matches.add(wrap);
            }
        }
        tasks.removeAll(matches);
        applyFilter(_filter);
    }

    public void sortByTimeRemaining() {
        filteredtasks.sort(new Comparator<TaskJobWrapper>() {
            @Override
            public int compare(TaskJobWrapper o1, TaskJobWrapper o2) {
                if (o1.getRemainingTime() < o2.getRemainingTime()) {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        });
    }

    public void applyFilter(String filter) {
        if (filter == null || filter.equals("LOCATION: ")) {
            filter = "";
        }
        _filter = filter;

        System.out.println(filter);

        filteredtasks.clear();
        for (TaskJobWrapper r: tasks) {
            if (r.getTask().getLocation().contains(filter)) {
                filteredtasks.add(r);

            }
        }
        sortByTimeRemaining();
        fireTableDataChanged();
    }

    public void addJobTask(Job j, Task t) {
        TaskJobWrapper _t = new TaskJobWrapper(j, t);
        tasks.add(_t);
    }
}
