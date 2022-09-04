package MyAGN;

import java.util.*;
import java.time.*;
/**
 * AGN is controller class and maintains Child and Donor objects
 * @author Shahryar
 */
public class AGN {

    private ArrayList<Child> agnChildren;
    private ArrayList<Donor> agnDonor;
    
    static Child child;
    
    /**
     * Constructor to initialize the Children array
     */
    public AGN()
    {
        agnChildren = new ArrayList<>();
        agnDonor = new ArrayList<>();
    }

    public ArrayList<Donor> getAgnDonor() {
        return agnDonor;
    }
    
    /**
     * a method to get information of a donor who sponsored a child 
     * @param myKad
     * @return String containing information of a donor who sponsored a child
     */
    public String donorForChild(String myKad)
    {
        String result = "";
        Child theChild;
        for(Child d: agnChildren)
        {
            if(d.getMyKadNo().equalsIgnoreCase(myKad))
            {
                theChild = d;
                ArrayList<Sponsorship> childSponsors = d.findSponsor();
                
                for(Sponsorship s: childSponsors)
                {
                    result += "Donor name:" + s.getDonor().getDonorName()
                            +". Donor email:" + s.getDonor().getEmail()+
                            ". Percentage:" + s.getPercentage()+
                            ". Value:"+s.getPercentage()+"\n";
                }
            }
        }
        return result;
    }
    
    /**
     * method to get info about Sponsorship and Child's age
     * @return String info about Sponsorship and Child's age
     */
    public String getSponsorship()
    {
        String result = "";
        
        for(Child c: agnChildren)
        {
            result += c.toString()+"\nCurrent Age:" + 
                    c.getAge(c.getDateOfBirth())+ ". Total percentage of "
                    + "sponsorship:"+c.totalPercentageSponsored()+"\n";
        }
        return result;
    }
    
    /**
     * method to get Information of Contribution(Sponsorship, Material, Monetary)
     * @param contNum
     * @return String Information of Contribution(Sponsorship, Material, Monetary)
     */
    public String contributionDetails(int contNum)
    {
        String details = null;
        for(Donor d: agnDonor)
        {
            Contribution c = d.findContribution(contNum);
            if(c != null)
            {
                String newString = c.getType();

                if (newString.equalsIgnoreCase("Sponsorship")) 
                {
                    double percentage = (c.getValue() * 100) / 150;
                    
                    for(Child child: agnChildren)
                    {
                        Child ch = child.findTheChild(contNum);
                        if(ch != null)
                        {
                            details = "Name:" + d.getDonorName() + ". Date of Contribution:"
                            + c.getDate() + " Percenttage sponsored:" + percentage
                            + ". Value of sponsorship:" + c.getValue()+
                            ". Child name:"+ch.getChildName()+". Age:"+
                            ch.getAge(ch.getDateOfBirth())+
                            " .Address:"+ch.getHomeAddress();
                        }
                    }
                    
                } 
                else if (newString.equalsIgnoreCase("Monetary")) 
                {
                    details = "Donor's name:"+d.getDonorName()+". Date of "
                            +"Contribution:"+c.getDate()+". Amount:"+c.getValue();
                } 
                else if (newString.equalsIgnoreCase("Material")) 
                {
                    Material m = c.getMaterial();
                    details = "Donor's name:" + d.getDonorName() + ". Date of "
                            +"Contribution:"+c.getDate()+". Material Type:"+
                            m.getCategory()+". Item Description:"+m.getItemDescription()
                            +". Value per unit:"+m.getValuePerUnit()+". Number "
                            +"of units:"+m.getNumUnitsContributed()+". Value:"+m.getValue();
                }  
                else {
                    return "Invalid choice!";
                }
            }
            
        }
        
        return details;
    }
    
    /**
     * method to all contributions
     * @param startDate
     * @param endDate
     * @return String of all contributions
     */
    public String seeContributions(LocalDate startDate, LocalDate endDate)
    {
        double total= 0;
        String myResult = "Contributions on this period: \n";
        for(Donor d: agnDonor){
            myResult += d.seeContribution(startDate, endDate);
            total += d.totalValueDate(startDate, endDate);
            if(total == 0)
                return null;
            else
                return myResult + "Total value of all contributions on this period:"+total+"\n";
        }
        return null;
    }
    
    /**
     * method to find a child based on myKadNo
     * @param myKadNo
     * @return Child object(found)
     */
    public Child findChild(String myKadNo)
    {
        for(Child c: agnChildren)
        {
            if(c.getMyKadNo().equalsIgnoreCase(myKadNo))
                return c;
        }
        return null;
    }
    
    /**
     * A method to record child to AGN
     * @param name
     * @param myKadNumber
     * @param homeAddress
     * @param dateOfBirth
     * @return Child that was created
     */
    public Child addChild(String name, String myKadNumber, 
            String homeAddress, LocalDate dateOfBirth)
    {
        Child newChild = new Child(name, myKadNumber, homeAddress, dateOfBirth);
        
        if(agnChildren.add(newChild)){
            return newChild;
        }
        
        return null;
   }
    
    /**
     * method to find Donor based on email
     * @param email
     * @return Donor object that was found
     */
    public Donor FindDonor(String email)
    {
        for(Donor d: agnDonor)
        {
            if(d.getEmail().equalsIgnoreCase(email))
                return d;
        }
        return null;
    }
    
    /**
     * method to add Donor
     * @param name
     * @param email
     * @return Donor that was created
     */
    public Donor addDonor(String name, String email)
    {
        Donor newDonor = new Donor(name, email);
        if(agnDonor.add(newDonor))
            return newDonor;
        return null;
    }
    
    /**
     * getting Child who is not sponsored 100%
     * @return String of a child who has not 100% scholarship
     */
    public String getNotFullySponsoredChild()
    {
        String result = "Children who do not have 100% sponsorship:\n";
        for(Child c: agnChildren)
        {
            if(c.totalPercentageSponsored() < 100)
            {
                result += c.toString() + "\n";
            }
        }
        return result;
    }
    
    
    /**
     * getting Child who is not sponsored 100% for GUI
     * @return ArrayList of Child who was not sponsored 100%
     */
    public ArrayList<Child> allNotFullySponsoredChild()
    {
        ArrayList<Child> childList = new ArrayList<>();
        for(Child c: agnChildren)
        {
            if(c.totalPercentageSponsored() < 100)
            {
                childList.add(c);
            }
        }
        return childList;
    }
    
    /**
     * getting array list of contributions between two dates for GUI
     * @param startDate
     * @param endDate
     * @return ArrayList of Contributions 
     */
    public ArrayList<Contribution>getAllContr(LocalDate startDate, LocalDate endDate)
    {
        ArrayList<Contribution> contrList = new ArrayList<>();
        for(Donor d: agnDonor)
        {
            contrList.addAll(d.getContr(startDate, endDate));
        }
        return contrList;
    }
    
    /**
     * getting all contributions for GUI
     * @return ArrayList of Contributions
     */
    public ArrayList<Contribution>getAllContr()
    {
        ArrayList<Contribution> contrList = new ArrayList<>();
        for(Donor d: agnDonor)
        {
            contrList.addAll(d.getContr());
        }
        return contrList;
    }
    
    /**
     * getting total value of all contributions between dates; 
     * @return total value of all contributions
     */
    public double totalContr(LocalDate startDate, LocalDate endDate)
    {
        double total = 0;
        ArrayList<Contribution> allContr = getAllContr(startDate, endDate);
        for(Contribution c: allContr)
        {
            total += c.getValue();
        }
        return total;
    }
    
    
    /**
     * getting all children for GUI
     * @return  ArrayList of Child
     */
    public ArrayList<Child>getAllChild()
    {
        return agnChildren;
    }
    
    /**
     * getting all sponsorships for GUI
     * @return ArrayList of Sponsorship
     */
    public ArrayList<Sponsorship>getAllSponsor()
    {
        ArrayList<Sponsorship> sponsorList = new ArrayList<>();
        for(Child c: agnChildren)
        {
            sponsorList.addAll(c.findSponsor());
        }
        return sponsorList;
    }
    
}