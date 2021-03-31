package GUI.TableWrappers;

import Account.CustomerAccount;
import Processing.TaskTypeFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;



class TaskFrameRowWrapper {
    private TaskTypeFrame c;

    public TaskFrameRowWrapper(TaskTypeFrame _c) {
        c = _c;
    }

    public TaskTypeFrame getTaskTypeFrame() {
        return c;
    }

    public String getColumnValue(Integer i) {
        switch (i.intValue()) {
            case 0:
                return c.Order.toString();
            case 1:
                return c.TaskName;
            case 2:
                return c.TaskDescription;
            case 3:
                return c.Price.toString();
            default:
                return "";
        }
    }

}

public class TaskTableModel extends AbstractTableModel {


    private static String[] columns = {"Order", "Name", "Description", "Price"};
    private final ArrayList<TaskFrameRowWrapper> tasktypes = new ArrayList<>();

    public void addElement(TaskTypeFrame c) {
        c.Order = tasktypes.size()+1;
        tasktypes.add(new TaskFrameRowWrapper(c));
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
        return tasktypes.get(row).getColumnValue(col);
    }

    public TaskTypeFrame getTaskFrameAt(int row) {
        return tasktypes.get(row).getTaskTypeFrame();
    }
}