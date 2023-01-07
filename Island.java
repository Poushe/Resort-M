import java.util.*;
/**
 * An island is part of a WIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * island at any one time. Each island must maintain a list of all people (cards)
 * currently on the island. These lists are updated whenever cards enter or leave 
 * an island,so that it is always possible to say which (cards) are on the island 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Island 
{
    
    private int id;
    private String name;
    private int rating;
    private ArrayList<Card> cards = new ArrayList<>();
    private int capacity;
    
    
    /**
    Constructor
      **/
    public Island (int id, String name, int rating, int capacity)
    {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.capacity = capacity;
        
    }
    
    
    
    /** This function returns island id     
     * @return an integer
     **/
    public int getId()
    {
        return this.id;
    }
    
    /**This function returns the island name
     * @return a string
     **/
    public String getName()
    {
        return this.name;
    }
    
    /**This function returns the luxary rating    
     * @return an integer
     **/
    public int getRating()
    {
        return this.rating;
    }
    
    /**This funciton returns the capacity of the island     
     * @return an integer
     **/
    public int getCapacity()
    {
        return this.capacity;
    }
    
    /**This function inserts a card in the island     
       * @param Card
       * @return boolean
     **/
    public boolean insert(Card card)
    {
        if(this.cards.size()<this.capacity)
        {
         if(card.getRating() >= this.rating)
         {
        this.cards.add(card);
        return true;
         }
         else
         return false;
        }
        
        else
        return false;
    }
    
    /** This function extracts the card from the island     
       * @param Card
       * @return a boolean
     **/
    public boolean leave(Card card)
    {
        for(int i=0; i<this.cards.size();++i)
        {
            if(this.cards.get(i).getId() == card.getId() )
            {
                this.cards.remove(this.cards.get(i));
                return true;
            }
        }
        
        
        return false;
    }
    
    /**This funciton checks if the island has reached its maximum capacity       
       * @return a boolean
     **/
    public boolean hasReachedCapacity()
    {
        if(this.cards.size()==this.capacity)
        return true;
        
        else
        return false;
    }
    
    /** This fucntion returns the string represntation of all cards
       * @return a String
     **/
    public String listCards()
    {
        String s = "";
        s += "These are the cards on this island:";
        
        if(this.cards.size()==0)
        s += "\nNo cards are present on this island";
        
        else
        for(int i=0; i<this.cards.size();++i)
        {
        s += "\nId: " + String.valueOf(this.cards.get(i).getId());
        }
        
        return s;

    }
    
    /** This fucntion returns the particular card
     
       * @param an integer
       * @return Card
     **/
    public Card searchCard(int id)
    {
        
            for(int i=0; i<this.cards.size();++i)
        {
            if(this.cards.get(i).getId() == id )
            {
                return (this.cards.get(i));
                
            }
        }
        
        
        
        return null;
        
    }
    
    /** This fucntion checks if the card is found on this island
     
       * @param Card
       * @return a boolean
     **/
    public boolean isCardFound(Card card)
    {
        
        for(int i=0; i<this.cards.size();++i)
        {
            if(this.cards.get(i).getId() == card.getId() )
            {
                return true;
                
            }
        }
        
        
        
        return false;
        
    }
    
    /** This fucntion returns the string format of an island     
     * @return a string
     **/
    public String toString()
    {
        String str = "";
        str += "\nId is - " + String.valueOf(this.id) + "\n";
        str += "Name is - " + this.name + "\n";
        str += "Luxary rating is - " + String.valueOf(this.rating) + "\n";
        str += "Capacity is - " + String.valueOf(this.capacity) + "\n";
        
        str += this.listCards();
        
        return str;
    }
    
    

    
}
