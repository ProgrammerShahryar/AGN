
package MyAGN;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shahryar
 */


public class MaterialTableModel extends AbstractTableModel {
    private Contribution contrib;
    private static final String colHeader[] = {"Donor Name", "Date", "Material", "Description", "Value per unit", "Number of units", "Total Value" };
    
    /**
     * Constructor for Material table model
     * @param contrib 
     */
    public MaterialTableModel(Contribution contrib)
    {
        setMaterial(contrib);
    }
    
    /**
     * setting Material which will be used in constructor
     * @param contrib 
     */
    public void setMaterial(Contribution contrib)
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
        Material theSponsor = (Material)contrib;
        switch(columnIndex)
        {
            case 0: return theSponsor.getDonor().getDonorName();
            case 1: return theSponsor.getDate();
            case 2: return theSponsor.getCategory();
            case 3: return theSponsor.getItemDescription();
            case 4: return theSponsor.getValuePerUnit();
            case 5: return theSponsor.getNumUnitsContributed();
            case 6: return theSponsor.getValue();
                    
            default: return "";
        }
    }
}
