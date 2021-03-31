package GUI.TableWrappers;

import Account.CustomerAccount;
import Processing.Controller;
import Processing.TaskTypeFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TaskTypeTableModel extends AbstractTableModel {


    private static String[] columns = {"TaskType", "Description", "Location", "Price", "Duration(m)"};
    private final ArrayList<TaskTypeFrame> tasktypes = new ArrayList<>();

    public void addElement(String TaskName, String TaskDescription, String Location, Float Price, Integer Duration) {
        TaskTypeFrame f = new TaskTypeFrame();
        f.TaskName = TaskName;
        f.TaskDescription = TaskDescription;
        f.Location = Location;
        f.Duration = Duration;
        f.Price = Price;
        tasktypes.add(f);
        fireTableRowsInserted(tasktypes.size()-1, tasktypes.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return tasktypes.size();
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public String getValueAt(int row, int col) {
        return tasktypes.get(row).getCol(col);
    }

    public TaskTypeFrame getTaskFrameAt(int row) {
        return tasktypes.get(row);
    }

    public void removeRow(int row) {
        tasktypes.remove(row);
        fireTableDataChanged();
    }
}