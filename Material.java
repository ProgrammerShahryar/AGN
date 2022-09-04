package MyAGN;

import java.time.*;

/**
 * Material is a subclass of Contribution and consist of details of Material
 * @author Shahryar
 */
public class Material extends Contribution 
{
    /**
     * Internal attributes of a Material
     */
    private MaterialType category;
    private String itemDescription;
    private double valuePerUnit;
    private int numUnitsContributed;
    
    /**
     * Constructor with validation
     * @param date
     * @param category
     * @param itemDescription
     * @param valuePerUnit
     * @param numUnitsContributed
     */
    public Material(LocalDate date, MaterialType category, String itemDescription, 
            double valuePerUnit, int numUnitsContributed)
    {
        super(date);
        this.category = category;
        if(!itemDescription.isEmpty())
            this.itemDescription = itemDescription;
        if(numUnitsContributed > 0)
            this.numUnitsContributed = numUnitsContributed;
        if(valuePerUnit > 0)
            this.valuePerUnit = valuePerUnit;
    }

    /**
     * getter for Material Type of a monetary contribution
     * @return Material Type of a monetary contribution
     */
    public MaterialType getCategory() {
        return category;
    }

    /**
     * setter for Material Type of a monetary contribution
     * @param category
     */
    public void setCategory(MaterialType category) {
        this.category = category;
    }

    /**
     * getter the description of monetary contribution
     * @return String description of monetary contribution
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * setter for description of monetary contribution
     * @param itemDescription
     */
    public void setItemDescription(String itemDescription) {
        if(!itemDescription.isEmpty())
            this.itemDescription = itemDescription;
    }

    /**
     * getter for value per unit contributed
     * @return double value per unit contributed
     */
    public double getValuePerUnit() {
        return valuePerUnit;
    }

    /**
     * setter for value per unit contributed
     * @param valuePerUnit
     */
    public void setValuePerUnit(double valuePerUnit) {
        this.valuePerUnit = valuePerUnit;
    }

    /**
     * getter number of units contributed
     * @return int number of units contributed
     */
    public int getNumUnitsContributed() {
        return numUnitsContributed;
    }

    /**
     * setter for number of units contributed
     * @param numUnitsContributed
     */
    public void setNumUnitsContributed(int numUnitsContributed) {
        this.numUnitsContributed = numUnitsContributed;
    }
    
    @Override
    public String getType()
    {
        return "Material";
    }
    
    @Override
    public double getValue(){
        return valuePerUnit * numUnitsContributed;
    }

    @Override
    public String toString() {
        return "Material{" + "category=" + category + ", itemDescription=" + itemDescription + ", valuePerUnit=" + valuePerUnit + ", numUnitsContributed=" + numUnitsContributed + '}';
    }
    
    
}
