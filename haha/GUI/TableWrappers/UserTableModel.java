package GUI.TableWrappers;

import Users.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class UserRowWrapper {
    private User c;

    public UserRowWrapper(User _c) {
        c = _c;
    }

    public User getUser() {
        return c;
    }

    public String getColumnValue(Integer i) {
        switch (i.intValue()) {
            case 0:
                return c.getName();
            case 1:
                return c.getAddress();
            case 2:
                return c.getDepartment();
            case 3:
                switch (c.getRole()) {
                    case 1:
                        return "OfficeManager";
                    case 2:
                        return "ShiftManager";
                    case 3:
                        return "Technician";
                    case 4:
                        return "Receptionist";
                    default:
                        return "bad column";
                }
            default:
                return "";
        }
    }

}

public class UserTableModel extends AbstractTableModel {


    private static String[] columns = {"Name", "Address", "Department", "Role"};
    private final ArrayList<UserRowWrapper> Users = new ArrayList<>();

    public void addElement(User c) {
        Users.add(new UserRowWrapper(c));
        fireTableRowsInserted(Users.size()-1, Users.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return Users.size();
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public String getValueAt(int row, int col) {
        return Users.get(row).getColumnValue(col);
    }

    public User getUserAt(int row) {
        return Users.get(row).getUser();
    }
}
