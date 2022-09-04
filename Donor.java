package MyAGN;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Donor.java - contains details of Donor object and Contribution arrayList
 * @author Shahryar
 */
public class Donor {
    
    /**
     * Internal attributes of a Donor
     */
    private String donorName;
    private String email;
    
    //arraylist to hold contributions for a donor
    private ArrayList<Contribution> donorContribution; 
    
    /**
     * Constructor with validation
     * @param donorName
     * @param email
     */
    public Donor(String donorName, String email) {
        if(!donorName.isEmpty())
            this.donorName = donorName;
        if(!email.isEmpty())
            this.email = email;
        
        //initialize array of contribution
        donorContribution = new ArrayList<>();
    }

    /**
     * calculating total value of contribution
     * @return double total value of contribution
     */
    public double totalContributionValue()
    {
        int total = 0;
        for(Contribution c: donorContribution)
        {
            total += c.getValue();
        }
        return total;
    }
    
    /**
     * to find contribution based on contribution number
     * @param contNum
     * @return found Contribution
     */
    public Contribution findContribution(int contNum)
    {
        for(Contribution c: donorContribution)
        {
            if(c.getContributionNo() == contNum)
                return c;
        }   
        return null;
    }
    
    /**
     * calculating total value of contribution during the dates
     * @param startDate
     * @param endDate
     * @return double total value of contribution during the dates
     */
    public double totalValueDate(LocalDate startDate, LocalDate endDate)
    {
        double total = 0;
        
        for(Contribution c: donorContribution)
        {
            LocalDate date = c.getDate();
            if(date.isAfter(startDate) && date.isBefore(endDate))
            {
                total += c.getValue();
            }   
        }
        return total;
    }
 
    /**
     * Shows Sorted contribution between a certain period
     * @param startDate
     * @param endDate
     * @return String containing contribution between a certain period
     */
    public String seeContribution(LocalDate startDate, LocalDate endDate)
    {
        Collections.sort(donorContribution);//added
        String result = "";

        for(Contribution c: donorContribution)
        {
            LocalDate myDate = c.getDate();
            
            if (myDate.isAfter(startDate) && myDate.isBefore(endDate)) 
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
                String date = myDate.format(formatter);

                result += "#" + c.getContributionNo() + "{ Date:" + date + ". Type:" + c.getType()
                        + ". Donor:" + getEmail() + ". Value:" + c.getValue() + ".}\n";
            }
        }
        
        return result;
    }
    
    /**
     * getting list of contributions between two dates
     * @param startDate
     * @param endDate
     * @return ArrayList of Contribution
     */
    public ArrayList<Contribution>getContr(LocalDate startDate, LocalDate endDate)
    {
        ArrayList<Contribution>contrArray = new ArrayList<Contribution>();
        for(Contribution c: donorContribution)
        {
            LocalDate theDate = c.getDate();
            if(theDate.isAfter(startDate) && theDate.isBefore(endDate)) 
            {
                contrArray.add(c);
            }
        }
        return contrArray;   
    }
    
    public ArrayList<Contribution>getContr()
    {
        return donorContribution;
    }
    
    /**
     * a method to add Sponsorship Contribution
     * @param sponsorship
     * @return Sponsorship that was created
     */
    public Sponsorship addSponsorship(Sponsorship sponsorship)
    {
        if(donorContribution.add(sponsorship))
            return sponsorship;
        return null;
    }
    
    /**
     * a method to add Monetary Contribution
     * @param date
     * @param amount
     * @return Monetary that was created
     */
    public Monetary addMonetary(LocalDate date, double amount)
    {
        Monetary m = new Monetary(date, amount);
        if(donorContribution.add(m))
            return m;
        return null;
    }
    
    /**
     * a method to add Material Contribution
     * @param date
     * @param category
     * @param description
     * @param valuePerUnit
     * @param unitsContributed
     * @return material that was created
     */
    public Material addMaterial(LocalDate date, MaterialType category, 
            String description, double valuePerUnit, int unitsContributed)
    {
        Material m;
        m = new Material(date, category, description, valuePerUnit, unitsContributed);
        m.setMaterial(m);
        if(donorContribution.add(m))
            return m;
        return null;
    }

    /**
     * getter for name of the donor
     * @return String donor name
     */
    public String getDonorName() {
        return donorName;
    }

    /** 
     * setter for name of donor with validation
     * @param donorName
     */
    public void setDonorName(String donorName) {
        if(!donorName.isEmpty())
            this.donorName = donorName;
    }

    /**
     * getter for email of the donor
     * @return String email of the donor
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email for the donor with validation
     * @param email
     */
    public void setEmail(String email) {
        if(!email.isEmpty())
            this.email = email;
    }

    /**
     * all the information of a Donor
     * @return String containing information of a Donor
     */
    @Override
    public String toString() {
        return "Donor{" + "donorName=" + donorName + ", email=" + email + '}';
    }
}
