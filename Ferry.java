
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ferry
{
    private String code;
    private Island source;
    private Island destination;
    
    //Constructor with parameters code, source, destination
    public Ferry(String code, Island source, Island destination)
    {
        this.code = code;
        this.source = source;
        this.destination = destination;
    }
    
    /** This fucntion returns the ferry code     
     * @return a String
     **/
    public String getCode()
    {
        return this.code;
    }
    
    /** This fucntion returns the source island    
     * @return Island
     **/
    public Island getSource()
    {
        return this.source;
    }
    
    /**This function returns the destination island    
     * @return Island
     **/
    public Island getDestination()
    {
        return this.destination;
    }
    
    /** This function ensures if a card can use this ferry
       * @param: Card
       * @return a boolean
     **/
    public boolean canUseFerry(Card card)
    {
        if(card.getRating()>=this.destination.getRating())
        {if(!this.destination.hasReachedCapacity())
        {if(card.getCredits()>=card.getFare())
        {if(this.source.isCardFound(card))
        return true;}}}
        
        return false;
    }
    
    /** This function process transaction if a journey is possible through this ferry     
       * @param: Card
       * @return a String
     **/
    public String processTransaction(Card card)
    {
        if(this.canUseFerry(card))
        {
            this.source.leave(card);
            this.destination.insert(card);
            card.processTransaction();
            
            return "Card debited and moved";
        }
        
        else if(card.getRating()<this.destination.getRating())
        return "Card cannot travel because its luxary rating is lower than the destination luxary rating";
        
        else if(this.destination.hasReachedCapacity())
        return "Card cannot travel because the destination island is full";
        
        else if(card.getCredits()<card.getFare())
        return "Card cannot travel because it doesnt have enough credits";
        
        else
        return "Card cannot travel because it is not present on the source island";
        
    }
    
    /**Returns the string for ferry format   
     * @return a string
     **/
    public String toString()
    {
        String s = "";
        s += "\nFerry Code is - " + String.valueOf(this.code) + "\n";
        s += "Source Island is - " + this.source + "\n";
        s += "Destination Island is - " + this.destination;
        
        return s;
        
    }
}
