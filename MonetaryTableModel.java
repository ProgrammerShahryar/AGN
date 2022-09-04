
package MyAGN;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */
public class MonetaryTableModel extends AbstractTableModel {
    private Contribution contrib;
    private static final String colHeader[] = {"Donor Name", "Date of Contribution", "Amount"};
    
    /**
     * Constructor for Monetary table model
     * @param contrib 
     */
    public MonetaryTableModel(Contribution contrib)
    {
        setMonetary(contrib);
    }
    
    /**
     * setting Monetary which will be used in constructor
     * @param contrib 
     */
    public void setMonetary(Contribution contrib)
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
    
    @Override
    public String getColumnName(int column)
    {
        return colHeader[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monetary theSponsor = (Monetary)contrib;
        switch(columnIndex)
        {
            case 0: return theSponsor.getDonor().getDonorName();
            case 1: return theSponsor.getDate();
            case 2: return theSponsor.getDonationAmount();
                    
            default: return "";
        }
    }
}
