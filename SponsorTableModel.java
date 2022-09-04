
package MyAGN;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */
public class SponsorTableModel extends AbstractTableModel {
    
    private ArrayList<Sponsorship> sponsors;
    private static final String[] colHeader = {"Donor Name", "Email", "Percentage of Sponsorship", "Value"};
    
    /**
     * Constructor for SponsorTableModel
     * @param sponsors 
     */
    public SponsorTableModel(ArrayList<Sponsorship> sponsors)
    {
        setSpon(sponsors);
    }
    
    /**
     * setter for Sponsorship which will be used in constructor 
     * @param sponsors 
     */
    public void setSpon(ArrayList<Sponsorship> sponsors)
    {
        this.sponsors = sponsors;
    }
    
    @Override
    public int getRowCount() {
        return sponsors.size();
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return colHeader[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sponsorship theSponsor = (Sponsorship) sponsors.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return theSponsor.getDonor().getDonorName();
            case 1: return theSponsor.getDonor().getEmail();
            case 2: return theSponsor.getPercentage();
            case 3: return theSponsor.getValue();
            default: return "";
        }
    }

}
