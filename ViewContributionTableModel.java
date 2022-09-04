
package MyAGN;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */
public class ViewContributionTableModel extends AbstractTableModel {
    
    // set up the column headers
    private static final String[] colHeader = {"Contribution No", "Date", "Type","Value", "Donor email"};
    
    private ArrayList<Contribution> contributions;
    
    /**
     * constructor to set the model to an array passed in
     * @param contributions 
     */
    public ViewContributionTableModel(ArrayList<Contribution> contributions) {
        setContr(contributions);
    }

    /**
     * setter for contribution arrayList
     * @param contributions 
     */
    public void setContr(ArrayList<Contribution> contributions) {
        this.contributions = contributions;
    }
    
    @Override
    public int getRowCount() {
        return contributions.size();		
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contribution theContr = contributions.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return theContr.getContributionNo();
            case 1: return theContr.getDate();
            case 2: return theContr.getType();
            case 3: return theContr.getValue();
            case 4: return theContr.getDonor().getEmail();
            default: return "";
        }
    }
    
    /**
     * to return the Contribution object at a specified row
     * @param index
     * @return Contribution that was selected
     */
    public Contribution getContrAt(int index) {
        Contribution theContr = contributions.get(index);
        return theContr;
    }
    
    public String getColumnName(int column)
    {
        return colHeader[column];
    }
}
