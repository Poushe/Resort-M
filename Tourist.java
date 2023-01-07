
/**
 * Write a description of class TouristCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tourist extends Card
{
    
    private String citizenship;

    /**
     * Constructo
     */
    public Tourist(int cardId, String ownerName, int luxaryRating, int credits, String citizenship)
    {
        
        super(cardId,ownerName, luxaryRating, credits);
        this.citizenship = citizenship;
        
        //Sets new fare
        this.setFare(4);
        
    }
    
    
    @Override
    //Overiding toString()
    public String toString()
   {
       String str = "";
       str+="Card Type: Tourist Card\nCitizenship: "+this.citizenship;
       str+=super.toString();
       return str;
      
       
       
       
   }

   
}
