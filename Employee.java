/**
 * Write a description of class TouristCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee extends Card
{
    // instance variables - replace the example below with your own
    private String job_description;
    private int employee_number;
    private int journey_score;


    /**
     * Constructor
     */
    public Employee(int cardId, String ownerName, int empN ,String jobDesc)
    {
        // initialise instance variables
        super(cardId,ownerName, 10, 0);
        this.job_description = jobDesc;
        this.employee_number = empN;
        this.journey_score = 0;
        
        //Set new fare
        this.setFare(0);
        
    }
    
    
    @Override
    
    public boolean processTransaction()
   {
       if(this.getCredits() >= this.getFare())
       {
           this.subtractCredits(this.getFare());
           this.addPoints(1);
           this.journey_score += 1;
           
           return true;
           
       }
       else
       {
           return false;
       }
   }
    
    
    @Override
    //Overiding toString()
    public String toString()
   {
       String str = "";
       str+="Card Type: Employee Card\nEmployee Number: "+this.employee_number+"\nJob Description: ";
       str +=  this.job_description + "\nJourney Score: " + this.journey_score;
       str += super.toString();
      return str;
       
       
       
   }

   
}
