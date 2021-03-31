package GUI.TableWrappers;

import Discount.JobFlexibleData;
import Processing.Controller;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class JobDiscountTableModel extends AbstractTableModel {
    private static String[] columns = {"JobType", "StartPrice", "EndPrice", "Amount"};
    private final ArrayList<JobFlexibleData> data = new ArrayList<>();

    public void addElement(JobFlexibleData d) {
        data.add(d);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }

    public JobFlexibleData getRowData(int i) {
        return data.get(i);
    }

    public ArrayList<JobFlexibleData> getValues() {
        return data;
    }

    @Override
    public int getColumnCount() { return columns.length; }

    @Override
    public int getRowCount() { return data.size(); }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public String getValueAt(int row, int col) {
        JobFlexibleData d = getRowData(row);
        switch (col) {
            case 0:
                return Controller.getJobTypes()[d.JobType-1];
            case 1:
                return d.StartPrice.toString();
            case 2:
                return d.EndPrice.toString();
            case 3:
                return ((Float)(d.Amount*100f)).toString()+"%";
            default:
                return "bad column";
        }
    }
}
