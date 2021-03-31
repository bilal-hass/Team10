package GUI.TableWrappers;

import Account.CustomerAccount;
import Processing.Controller;
import Processing.TaskTypeFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class TaskDiscountFrame {
    private Integer TaskType;
    private Float Amount;

    public String getTypeString() {
        String[] types = Controller.getTaskTypeStrings();
        return types[TaskType];
    }

    public Integer getType() {
        return TaskType+1;
    }

    public TaskDiscountFrame(Integer type, Float a) {
        TaskType = type;
        Amount = a;
    }

    public Float getAmount() {
        return Amount;
    }
}

class TaskDiscountRowWrapper {
    private TaskDiscountFrame c;

    public TaskDiscountRowWrapper(TaskDiscountFrame _c) {
        c = _c;
    }

    public TaskDiscountFrame getTaskDiscountFrame() {
        return c;
    }

    public String getColumnValue(Integer i) {
        switch (i.intValue()) {
            case 0:
                return c.getTypeString();
            case 1:
                return ((Float)(c.getAmount()*100f)).toString() + "%";
            default:
                return "";
        }
    }

}

public class TaskDiscountTableModel extends AbstractTableModel {


    private static String[] columns = {"TaskType", "Discount"};
    private final ArrayList<TaskDiscountRowWrapper> taskdiscounts = new ArrayList<>();

    public void addElement(Integer TypeIndex, Float Amount) {

        taskdiscounts.add(new TaskDiscountRowWrapper(new TaskDiscountFrame(TypeIndex, Amount)));
        fireTableRowsInserted(taskdiscounts.size()-1, taskdiscounts.size()-1);
    }

    public Boolean hasElementOfTaskType(Integer TypeIndex) {
        for (TaskDiscountRowWrapper d: taskdiscounts) {
            if (d.getTaskDiscountFrame().getType() == TypeIndex+1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return taskdiscounts.size();
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public String getValueAt(int row, int col) {
        return taskdiscounts.get(row).getColumnValue(col);
    }

    public TaskDiscountFrame getTaskFrameAt(int row) {
        return taskdiscounts.get(row).getTaskDiscountFrame();
    }
}