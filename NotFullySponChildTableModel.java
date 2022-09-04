/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAGN;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */
public class NotFullySponChildTableModel extends AbstractTableModel {
    
    private static final String[] colHeader = {"Child Name", "MyKad No", "Home Address", "Date of Birth"};
    
    private ArrayList<Child> childNot100;
    
    /**
     * Constructor for NotFullySponChildTableModel
     * @param childNot100 
     */
    public NotFullySponChildTableModel(ArrayList<Child> childNot100) {
        setChild(childNot100);
    }

    /**
     * setter for Child,  will be used in constructor
     * @param childNot100 
     */
    public void setChild(ArrayList<Child> childNot100) {
        this.childNot100 = childNot100;
    }
    
    @Override
    public int getRowCount() {
        return childNot100.size();
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Child theChild = childNot100.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return theChild.getChildName();
            case 1:
                return theChild.getMyKadNo();
            case 2:
                return theChild.getHomeAddress();
            case 3:
                return theChild.getDateOfBirth();
            default:
                return "";
        }

    }
    
    @Override
    public String getColumnName(int column) {
        return colHeader[column];
    }
    
    /**
     * getting selected child from table
     * @param index
     * @return child that was selected
     */
    public Child getChildAt(int index) {
        Child theChild = childNot100.get(index);
        return theChild;
    }
    
}
