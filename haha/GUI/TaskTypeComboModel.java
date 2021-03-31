package GUI;

import Processing.TaskTypeFrame;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class TaskTypeComboModel extends DefaultComboBoxModel {
    ArrayList<TaskTypeFrame> data;
    private Object selectedItem;
    public TaskTypeComboModel(ArrayList<TaskTypeFrame> _data) {
        data = _data;
    }

    @Override
    public void addElement(Object f) {
        data.add((TaskTypeFrame)f);
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Object getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object item) {
        selectedItem = item;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
