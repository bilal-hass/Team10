package GUI.TableWrappers;

import GUI.DynamicTableModel;
import Processing.Job;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class JobWrapper {
    private Job job;
    public JobWrapper(Job j) {
        job = j;
    }

    public Job getJob() {
        return job;
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

        return( (neg ? "-" : "") + sb.toString()) + " ago";
    }

    public String getColumnValue(Integer i) {

        switch(i) {
            case 0:
                return getDurationBreakdown(job.getBookingTime());
            case 1:
                return job.getId().toString();
            case 2:
                return job.getTypeString();
            default:
                return "bad column";
        }
    }
}

public class JobTableModel extends DynamicTableModel {
    private final ArrayList<JobWrapper> jobs = new ArrayList<>();
    private final ArrayList<JobWrapper> filteredjobs = new ArrayList<>();
    private static String[] columns = {"Booked", "Job ID", "Job Type"};
    private String _filter;

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int i) { return columns[i];}

    @Override
    public int getRowCount() { return filteredjobs.size(); }

    @Override
    public String getValueAt(int row, int col) { return filteredjobs.get(row).getColumnValue(col); }

    public JobTableModel() {
        _filter = "";
    }

    public Job getJobAt(int row) {
        return filteredjobs.get(row).getJob();
    }

    public void applyFilter(String filter) {
        filteredjobs.clear();
        filteredjobs.addAll(jobs);
        fireTableDataChanged();
    }

    public void addJob(Job j) {
        jobs.add(new JobWrapper(j));applyFilter("");
    }
}
