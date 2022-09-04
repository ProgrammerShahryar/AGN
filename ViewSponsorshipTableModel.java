
package MyAGN;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;




public class ViewSponsorshipTableModel extends AbstractTableModel{
    
    private ArrayList<Child> children;
    private static final String[] colHeader = {"Child Name", "Home address", "Age", "Total Sponsored"};
    
    /**
     * constructor to set the model to an array passed in
     * @param children 
     */
    public ViewSponsorshipTableModel(ArrayList<Child> children) { 
	setChild(children);
    }
    /**
     * setter for child arrayList which will be used in constructor
     * @param children 
     */
    public void setChild(ArrayList<Child> children) {
        this.children = children;
    }
    
    public String getColumnName(int column)
    {
        return colHeader[column];
    }
    
    @Override
   // number of rows is the size of the arraylist (all orders)
    public int getRowCount() {
        return children.size();		
    }

    @Override
    // number of columns follows the column header
    public int getColumnCount() {
        return colHeader.length;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Child theChild = children.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return theChild.getChildName();
            case 1: return theChild.getHomeAddress();
            case 2: return theChild.getAge(theChild.getDateOfBirth());
            case 3: return theChild.totalPercentageSponsored();
            default: return "";
        }
    }
    
    /**
     * to return the Child object at a specified row  
     * @param index
     * @return Child that was selected
     */
    public Child getChildAt(int index) 
    {
        Child theChild = children.get(index);
        return theChild;
    }
}
