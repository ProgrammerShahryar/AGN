package MyAGN;

import java.time.*;
import java.util.*;

/** Child.java - is a class that holds sponsorship arrayList and details of child
 *
 * @author Shahryar
 */
public class Child {
    
    /**
     * Internal attributes of a Child
     */
    private String childName;
    private String myKadNo;
    private String homeAddress;
    private LocalDate dateOfBirth;
    
    //array that contains all the Sponsorships for a Child
    private ArrayList<Sponsorship> childSponsorship; 

    /**
     * Constructor for a Child class with validation
     * @param childName
     * @param myKadNo
     * @param homeAddress
     * @param dateOfBirth
     */
    public Child(String childName, String myKadNo, String homeAddress, LocalDate dateOfBirth)
    {
        if(!childName.isEmpty())
            this.childName = childName;
        this.dateOfBirth = dateOfBirth;
        if(!homeAddress.isEmpty())
            this.homeAddress = homeAddress;
        if(!myKadNo.isEmpty())
            this.myKadNo = myKadNo;
        
        //initiaizing array of sponsorships inside constructor
        childSponsorship = new ArrayList<>();
    }
    
    /**
     * a method to get ArrayList of Sponsorship
     * @return ArrayList of Sponsorship
     */
    public ArrayList<Sponsorship> findSponsor()
    {
        return childSponsorship;
    }

    /**
     *
     * @param contNum
     * @return found Child
     */
    public Child findTheChild(int contNum)
    {
        for(Sponsorship s: childSponsorship)
        {
            if(s.getContributionNo() == contNum)
                return this;
        }
        return null;
    }

    /**
     * method to add Sponsorship to the child
     * @param date
     * @param percentage
     * @return sponsorship that was created
     */
    public Sponsorship addSponsorship(LocalDate date, int percentage)
    {
        Sponsorship s = new Sponsorship(date, percentage);
        if(childSponsorship.add(s))
        {
            return s;
        }
        return null;
    }
    
    /**
     * method to calculate total percentage of sponsorship for child
     * @return int of total percentage of sponsorship for the child
     */
    public int totalPercentageSponsored()
    {
        int result = 0;
        for(Sponsorship s: childSponsorship)
        {
            result += s.getPercentage();
        }
        return result;
        
    }
    
    /**
     * getter for age of the child
     * @param dateOfBirth of the child
     * @return int age of the child
     */
    public int getAge(LocalDate dateOfBirth)
    {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    /**
     * getter for a name of the child
     * @return String of the child name
     */
    public String getChildName() {
        return childName;
    }

    /**
     * setter for child name with validation
     * @param childName
     */
    public void setChildName(String childName) {
        if(!childName.isEmpty())
            this.childName = childName;
    }

    /**
     * getter for a myKad number of the child
     * @return String of a child's myKad number
     */
    public String getMyKadNo() {
        return myKadNo;
    }

    /**
     * setter for myKad number of the child with validation
     * @param myKadNo
     */
    public void setMyKadNo(String myKadNo) {
        if(!myKadNo.isEmpty())
            this.myKadNo = myKadNo;
    }

    /**
     * setter for home address of the child with validation
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        if(!homeAddress.isEmpty())
            this.homeAddress = homeAddress;
    }

    /**
     * getter for home address of the child
     * @return String of the child's home address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * setter of birthDate of the child
     * @param dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * getter for birthDate of the child
     * @return
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     *
     * @return String containing all the information of the child
     */
    @Override
    public String toString() {
        return "Child{" + "childName=" + childName + ", myKadNo=" + myKadNo + ", homeAddress=" + homeAddress + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
}
