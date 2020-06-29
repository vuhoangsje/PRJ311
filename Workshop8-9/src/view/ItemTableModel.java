
package view;

import entity.*;


public class ItemTableModel extends TableModel<Item> {

    public ItemTableModel(String[] headers, int[] indexes, int maxRow) {
        super(headers, indexes, maxRow);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        rowIndex = getIndex(rowIndex);
        if (columnIndex < 0 || columnIndex >= headers.length
                || rowIndex < 0 || rowIndex >= data.size()) {
            return null;
        }
        Item item = data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 0:
                return item.getCode();
            case 1:
                return item.getName();
            case 2:
                return item.getSupCode();
            case 3:
                return item.getUnit();
            case 4:
                return item.getPrice();
            case 5:
                return item.isSupplying();
        }
        return null;
    }
}
