
package view;
import entity.*;


public class SupplierTableModel extends TableModel<Supplier> {

    public SupplierTableModel(String[] headers, int[] indexes, int maxRow) {
        super(headers, indexes, maxRow);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        rowIndex = getIndex(rowIndex);
        if (columnIndex < 0 || columnIndex >= headers.length
                || rowIndex < 0 || rowIndex >= data.size()) {
            return null;
        }
        Supplier sup = data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 0:
                return sup.getCode();
            case 1:
                return sup.getName();
            case 2:
                return sup.getAddress();
            case 3:
                return sup.isColloboration();
        }
        return null;
    }

}
