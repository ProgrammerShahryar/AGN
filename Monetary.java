package MyAGN;

import java.time.*;

/**
 * Monetary is a subclass of Contribution and consist of details of Monetary
 * @author Shahryar
 */
public class Monetary extends Contribution 
{
    /**
     * Internal attributes of a Monetary
     */
    private double donationAmount;
    
    /**
     * Constructor with validation
     * @param date
     * @param donationAmount
     */
    public Monetary(LocalDate date, double donationAmount)
    {
        super(date);
        if(donationAmount > 0)
            this.donationAmount = donationAmount;
    }

    /**
     * getter for the amount of Monetary Donation
     * @return double amount of Monetary Donation
     */
    public double getDonationAmount() {
        return donationAmount;
    }

    /**
     * setter for the amount of Monetary Donation with validtion
     * @param donationAmount
     */
    public void setDonationAmount(double donationAmount) {
        if(donationAmount > 0)
            this.donationAmount = donationAmount;
    }
    
    @Override
    public String getType()
    {
        return "Monetary";
    }
    
    
    @Override
    public double getValue(){
        return donationAmount;
    }

    @Override
    public String toString() {
        return "Monetary{" + "donationAmount=" + donationAmount + '}';
    }
}
