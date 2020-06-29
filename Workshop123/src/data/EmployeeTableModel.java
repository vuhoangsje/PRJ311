/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vuhoa
 */
public class EmployeeTableModel <E> extends AbstractTableModel{
    String[] header;
    int[] indexes;
    EmpList data;
    EmpList mainData = new EmpList();
    int maxRow;
    int currentPage;
    boolean search;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public EmployeeTableModel(String[] header, int[] indexes, int maxRow) {
        int i = 0;
        
        this.header =  new String[header.length];
        for ( i = 0; i < header.length; i++) {
            this.header[i] = header[i];
        }
        this.indexes = new int[indexes.length];
        for (i = 0; i < indexes.length; i++) {
            this.indexes[i] = indexes[i];
        }
        this.data = new EmpList();
        this.maxRow = maxRow;
        currentPage = 0;
        search = false;
        data = mainData;
    }
    public Vector<Employees> getData(){
        return data;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return (column >= 0 && column < header.length)?
                header[column]: "";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex < 0 || rowIndex >= data.size() 
           || columnIndex < 0 || columnIndex >= header.length){
            return null;
        }
        Employees emp = data.get(rowIndex);
        switch (indexes[columnIndex]){
            case 0: return emp.getCode();
            case 1: return emp.getName();
            case 2: return emp.getAddress();
            case 3: return emp.isGender();
            case 4: return emp.getSalary();
        }
    return null;
    }  

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }
    public int getMaxPage(){
        int maxPage = (data.size() / maxRow);
        if (maxRow == -1){
            return 1;
        }else if(data.size() % maxRow == 0){
            return maxPage - 1;
        }else{
            return maxPage;
        }
    }
    public void  searching(String name){
        currentPage = 0;
        data = data.findName(name);
        search = true;
    }
    public int getIndex(int row){
        return row + currentPage * maxRow;
    }
    public void resetSearch(){
        search = false;
        data = mainData;
    }
    public  void remove(Employees e){
        mainData.remove( e);
        if (isSearch()){
            data.remove(e);
        }
    }
}
