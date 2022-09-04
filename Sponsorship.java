package MyAGN;

import java.time.*;

/**
 * Sponsorship is a subclass of Contribution and consist of details of Sponsorship
 * @author Shahryar
 */
public class Sponsorship extends Contribution 
{
    
    /**
     * Internal attributes of a Sponsorship
     */
    private int percentage;
    private final double maxSponsorship = 150;
    
    private Child theChild;

    /**
     * getter for child object
     * @return 
     */
    public Child getTheChild() {
        return theChild;
    }

    /**
     * setter for child object
     * @param theChild 
     */
    public void setTheChild(Child theChild) {
        this.theChild = theChild;
    }
    
    /**
     * Constructor with validation
     * @param date
     * @param percentage
     */
    public Sponsorship(LocalDate date, int percentage)
    {
        super(date);
        if(percentage > 0)
            this.percentage = percentage;
    }
    
    @Override
    public double getValue(){
        return (maxSponsorship * percentage) / 100;
    }
    
    /**
     * getter for percentage of a sponsorship
     * @return int percentage of a sponsorship
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * setter for percentage of a sponsorship with validation
     * @param percentage
     */
    public void setPercentage(int percentage) {
        if(percentage > 0)
            this.percentage = percentage;
    }
    
    @Override
    public String getType()
    {
        return "Sponsorship";
    }
    
    @Override
    public String toString() {
        return "Sponsorship{" + "percentage=" + percentage + '}';
    }
}
