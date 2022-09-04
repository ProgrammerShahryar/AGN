
package MyAGN;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */
public class SponsorshipTableModel extends AbstractTableModel {
    
    private Contribution contrib;
    private static final String colHeader[] = {"Donor Name", "Date", "Percentage", "Value", "Child Name", "Age", "Home Address" };
    
    /**
     * constructor to set the model to an array passed in
     * @param contrib 
     */
    public SponsorshipTableModel(Contribution contrib)
    {
        setSponsor(contrib);
    }
    
    /**
     * setter for contribution local variable
     * @param contrib 
     */
    public void setSponsor(Contribution contrib)
    {
        this.contrib = contrib;
    }
    
    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    public String getColumnName(int column)
    {
        return colHeader[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sponsorship theSponsor = (Sponsorship)contrib;
        switch(columnIndex)
        {
            case 0: return theSponsor.getDonor().getDonorName();
            case 1: return theSponsor.getDate();
            case 2: return theSponsor.getPercentage();
            case 3: return theSponsor.getValue();
            case 4: return theSponsor.getTheChild().getChildName();
            case 5: return theSponsor.getTheChild().getAge(theSponsor.getTheChild().getDateOfBirth());
            case 6: return theSponsor.getTheChild().getHomeAddress();
                    
            default: return "";
        }
    }
}
