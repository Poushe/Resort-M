/**
 * A Card has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card 
{
   //fields
   private int cardId; // card id
   private String name; // person's name
   private int rating; // luxary rating
   private int credits; // number of credits
   private int journey_points; //journey points
   private int fare; //travel fare
   
    
   //constructor
   /**
    Constructor with fields cardId, name, rating and credits and sets journey points to zero
    **/
   public Card(int cardId, String name, int rating, int credits)
   {
       this.cardId = cardId;
       this.name = name;
       this.rating = rating;
       this.credits = credits;
       this.journey_points = 0;
       this.fare = 3;
   }
 
   
   
   //methods
   /**Returns the card id     
     * @return an int which represents the card id of the card
    **/
   public int getId()
   {
       return this.cardId;
   }
   
   /** This function returns the person's name
     * @return the person's name as String
    **/
   public String getName()
   {
       return this.name;
   }
   
   /** This function returns the luxary rating     
     * @return an integer
    **/
   public int getRating()
   {
       return this.rating;
   }
   
   /** This function returns the credits parameter     
     * @return an integer
    **/
   public int getCredits()
   {
       return this.credits;
   }
   
   
   /** This function returns the journey points parameter    
     * @return an integer
    **/
   public int getJourneyPoints()
   {
       return this.journey_points;
   }
   
   /**This function adds the points to the card     
     * @param an int which represents the journey points to be added to the card
     **/
   public void addPoints(int points)
   {
       this.journey_points += points;
   }
   
   /**This function sets the fare    
     * @param an integer
     **/
   public void setFare(int fare)
   {
       this.fare = fare;
   }
   
   /**This function returns the fare for the card    
     * @return an integer
     **/
   public int getFare()
   {
       return this.fare;
   }
   
   /**This funxtion adds the credits to the card     
     * @param an integer
     **/
   public void addCredits(int credit)
   {
       this.credits += credit;
   }
   
   /**This function substracts the credits from the card     
     * @param an integer
     **/
   public void subtractCredits(int credit)
   {
       this.credits -= credit;
   }
   
   /**This function debits the card for a ferry journey     
     * @return a boolean 
     **/
   public boolean processTransaction()
   {
       if(this.credits >= this.fare)
       {
           this.credits -= this.fare;
           this.journey_points += 1;           
           return true;
           
       }
       else
       {
           return false;
       }
   }
   
   /**Converts the journey points to credits     
     * @return a boolean
     **/
   public boolean convertJPCs()
   {
       if(this.journey_points>=5)
       {
           this.credits += this.journey_points/5;
           this.journey_points = this.journey_points%5;
           return true;           
       }
       
       else
       {
           return false;
       }
   }
   
   /**This function returns the string form of card
     * @return a string
     **/
   public String toString()
   {
       String strr = "";
       strr+="\nCard ID - " + String.valueOf(this.cardId) + "\n";
       strr+="Name - " + this.name + "\n";
       strr+="Luxary Rating - " + String.valueOf(this.rating) + "\n";
       strr+="Credits - " + String.valueOf(this.credits) + "\n";
       strr+="Journey Points - " + String.valueOf(this.journey_points);
       return strr;     
       
       
   }
  

}


   
  



