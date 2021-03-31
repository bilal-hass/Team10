package GUI;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DynamicTableModel extends AbstractTableModel {
    public final ArrayList<String> columnNames = new ArrayList<>();
    private final ArrayList<String[]> data = new ArrayList<>();

    public void addElement(String[] e) {
        data.add(e);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int i) {
        return columnNames.get(i);
    }

    public void setColumnNames(ArrayList<String> s) {
        columnNames.clear();
        columnNames.addAll(s);
        fireTableStructureChanged();
    }

    @Override
    public String getValueAt(int i, int j) {
        return data.get(i)[j];
    }
}
