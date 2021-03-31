package GUI;


import java.util.ArrayList;

public class SelectionPopUpCaller {

    private ArrayList<SelectionListener> SelectionListeners;
    public SelectionPopUpCaller() {
        SelectionListeners = new ArrayList<>();
    }

    public void addSelectionListener(SelectionListener l) {
        SelectionListeners.add(l);
    }

    public void SelectionMade(Object Selection) {
        System.out.println("SELECTION MADE");
        for (SelectionListener l: SelectionListeners) {
            System.out.println("FIRE LISTENER");

            System.out.println(l.toString());

            l.selectionMade(Selection);
        }
    }

    public Object selection;
}
