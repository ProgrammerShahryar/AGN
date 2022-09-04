package MyAGN;

import java.time.*;
import java.util.ArrayList;

/**
 * Contribution is a super and an abstract class(as there are different types 
 * of contribution: Sponsorship, Monetary, Material which are subclasses)
 * @author Shahryar
 */
public abstract class Contribution implements Comparable<Contribution>//added
{
    /**
     * Internal attributes of a Contribution
     */
    private int contributionNo; // the number of contribution
    private static int nextNo = 1000;
    private LocalDate date;
    
    Donor donor;
    Material material;
    Sponsorship sponsorship;
    
    /**
     * Constructor
     * @param date
     */
    public Contribution(LocalDate date)
    {
        contributionNo = nextNo++;
        this.date = date;
    }
    
    @Override
    public int compareTo(Contribution obj)//////addedddd
    {
        if (this == obj) // identical object
        {
            return 0;
        }
        return (this.getDate().compareTo(obj.getDate())); // using String compareTo
    }
    
    /**
     * getter for Material object in Contribution
     * @return Material object
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * setter for Material object
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    /**
     * getter for Donor object
     * @return Donor object
     */
    public Donor getDonor()
    {
        return donor;
    }
    
    /**
     * setter for Donor object
     * @param donor
     */
    public void setDonor(Donor donor)
    {
        this.donor = donor;
    }

    /**
     * getter for Contribution number
     * @return int number of a Contribution
     */
    public int getContributionNo() {
        return contributionNo;
    }

    /**
     * getter for date of contribution
     * @return LocalDate
     */
    public LocalDate getDate() {
        return date;
    }
    
    /**
     * getter for type of Contribution
     * @return String, type of a Contribution
     */
    abstract public String getType();
    
    /**
     * getter for value of a Sponsorship according to type
     * @return double, value of a Sponsorship
     */
    abstract public double getValue(); 
    
    /**
     * getter information of a contribution according to type
     * @return
     */
    @Override
    abstract public String toString();
}
