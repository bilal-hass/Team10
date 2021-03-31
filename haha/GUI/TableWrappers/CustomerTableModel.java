package GUI.TableWrappers;

import Account.CustomerAccount;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class CustomerRowWrapper {
    private CustomerAccount c;

    public CustomerRowWrapper(CustomerAccount _c) {
        c = _c;
    }

    public CustomerAccount getCustomer() {
        return c;
    }

    public String getColumnValue(Integer i) {
        switch (i.intValue()) {
            case 0:
                return c.getName();
            case 1:
                return c.getAddress();
            case 2:
                return c.getPhoneNumber();
            case 3:
                return c.getEmail();
            case 4:
                return (c.getValued() ? "YES" : "NO");
            default:
                return "";
        }
    }

}

public class CustomerTableModel extends AbstractTableModel {


    private static String[] columns = {"Name", "Address", "Phone", "Email", "Valued"};
    private final ArrayList<CustomerRowWrapper> customers = new ArrayList<>();

    public void addElement(CustomerAccount c) {
        customers.add(new CustomerRowWrapper(c));
        fireTableRowsInserted(customers.size()-1, customers.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public String getValueAt(int row, int col) {
        return customers.get(row).getColumnValue(col);
    }

    public CustomerAccount getCustomerAt(int row) {
        return customers.get(row).getCustomer();
    }
}
