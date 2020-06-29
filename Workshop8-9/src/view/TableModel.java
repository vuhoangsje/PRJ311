
package view;

import javax.swing.table.AbstractTableModel;
import entity.*;
import java.util.Vector;

public abstract class TableModel<E> extends AbstractTableModel {

    String[] headers;
    int[] indexes;
    Vector<E> data;
    int maxRow;
    int currentPage;

    public TableModel(String[] headers, int[] indexes, int maxRow) {
        int i = 0;
        this.headers = new String[headers.length];
        for (i = 0; i < headers.length; i++) {
            this.headers[i] = headers[i];
        }
        this.indexes = new int[indexes.length];
        for (i = 0; i < indexes.length; i++) {
            this.indexes[i] = indexes[i];
        }
        this.maxRow = maxRow;
        currentPage = 0;
        data = new Vector<>();
    }

    public Vector<E> getData() {
        return data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    @Override
    public int getRowCount() {
        return (maxRow == -1) ? data.size() : maxRow;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return (column >= 0 || column < headers.length) ? this.headers[column] : "";
    }
    public int getMaxPage() {
        // return -1 if data size is empty
        // begin at 0;
        int maxPage = (data.size() / maxRow);
        if (maxRow == -1) {
            return 1;
        } else if (data.size() % maxRow == 0) {
            return maxPage - 1;
        } else {
            return maxPage;
        }
    }

    public int getIndex(int row) {
        return row + currentPage * maxRow;
    }

}
