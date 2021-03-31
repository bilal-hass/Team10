package GUI.TableWrappers;

import GUI.DynamicTableModel;
import Processing.Job;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import Discount.Discount;

class DiscountWrapper {
    private Discount discount;
    public DiscountWrapper(Discount j) {
        discount = j;
    }

    public Discount getDiscount() {
        return discount;
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
                return discount.getName();
            case 1:
                return discount.getDescription();
            case 2: {
                switch(discount.getType()) {
                    case FIXED:
                        return "FLAT";
                    case VARIABLE:
                        return "VARIABLE";
                    case FLEXIBLE:
                        return "FLEXIBLE";
                }
            }


            default:
                return "bad column";
        }
    }
}

public class DiscountTableModel extends DynamicTableModel {
    private final ArrayList<DiscountWrapper> discounts = new ArrayList<>();
    private final ArrayList<DiscountWrapper> filtereddiscounts = new ArrayList<>();
    private static String[] columns = {"Name", "Description", "Type"};
    private String _filter;

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int i) { return columns[i];}

    @Override
    public int getRowCount() { return filtereddiscounts.size(); }

    @Override
    public String getValueAt(int row, int col) { return filtereddiscounts.get(row).getColumnValue(col); }

    public DiscountTableModel() {
        _filter = "";
    }

    public Discount getDiscountAt(int row) {
        return filtereddiscounts.get(row).getDiscount();
    }

    public void removeDiscount(Discount d) {
        ArrayList<DiscountWrapper> matches = new ArrayList<>();
        for (DiscountWrapper w: discounts) {
            if (w.getDiscount().getId().equals(d.getId())) {
                matches.add(w);
            }
        }
        discounts.removeAll(matches);
        applyFilter("");
    }

    public void applyFilter(String filter) {
        filtereddiscounts.clear();
        filtereddiscounts.addAll(discounts);
        fireTableDataChanged();
    }

    public void addDiscount(Discount j) {
        discounts.add(new DiscountWrapper(j));applyFilter("");
        applyFilter("");
    }
}
