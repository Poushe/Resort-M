
/**
 * Write a description of class BusinessCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Business extends Card
{
    
    private int loyalty_points;

    /**
     * Constructor for objects of class BusinessCard
     */
     public Business(int id, String name, int rating)
    {
        
        super(id,name, rating, 30);
        this.loyalty_points = 20;
        
        
        
    }

    @Override
    public boolean processTransaction()
   {
       if(this.getCredits() >= this.getFare())
       {
           this.subtractCredits(this.getFare());
           this.addPoints(1);
           this.loyalty_points += 2;
           
           return true;
           
       }
       else
       {
           return false;
       }
   }
   
   
   public boolean convertLoyalityPointsToCredits()
   {
       if(this.loyalty_points>=3)
       {
           int credits = this.loyalty_points/3;
           this.addCredits(credits);
           this.loyalty_points = this.loyalty_points%3;
           return true;
           
       }
       
       else
       {
           return false;
       }
   }
   
   @Override
    
    public String toString()
   {
       String str = "";
       str+="Card Type: Business Card\nLoyality Points: "+this.loyalty_points;
       str += super.toString();
       return str;
       
       
       
   }
}
