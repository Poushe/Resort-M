import java.util.*;

/**This class implements the WIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/22
 **/
public class Resort implements WIRE   // do not change this header
{

    private String location;
    // Other fields (including collections)
    private ArrayList<Island> listIslands;
    private ArrayList<Ferry> listFerries;
    private ArrayList<Card> listCards;

    /** constructor
     * Some code has been provided 
     */
    public Resort(String loc) 
    {
        location = loc;
        loadIslandsAndFerries();
        loadCards();
        // Ensure all cards are added to Base Island
        // you may do this here or in one of the above method
        for(int i=0;i<this.listCards.size();++i)
        this.listIslands.get(0).insert(this.listCards.get(i));
        
    }
    
    /**
     * Returns information about the resort including its location/name and all
     * cards currently on each island, or "No cards" (if no card on that island
     * @return all of the details of all islands including location 
     * and all cards currently on each island, or "No cards" if island has no cards
     */
    public String toString()
    {
        String s = "";        
        s += "\nResort location is - " + this.location + "\n";
        s += this.getAllCardsOnAllIslands();       
        return s;
    }

    /**Returns a String representation of all the cards on all islands
     * with "No cards" if there are no cards on an island
     * @return a String representation of all cards on all islands
     **/
    public String getAllCardsOnAllIslands()
    {
        String s = "\nLocation of Cards\n";
        for(Island island : this.listIslands)
        s += island.toString();        
        return s;
    } 
 
    
    /**Returns the name of the island which contains the specified card or "Not found"
     * @param cd -the id of the card
     * @return the name of the Island which contains the card, or "Not found"
     **/
    public String findCardLocation(int cd)
    {
        for(Island island : this.listIslands)
        {
            if(island.searchCard(cd)!=null)
            return island.getName();
        }
        return "Not found";
    }
    
    /**Returns details of the card with the specified id or "Not found"
     * @param cd - the id of the card
     * @return the details of the card, or "Not found"
     **/
    public String viewACard(int cd)
    {
        Card card = this.getCard(cd);
        if(card!=null)
        return card.toString();       
        else       
        return "Not found";
    }
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        
        Island island = this.getIsland(isl);
        
        if(island != null)
        return island.getId();
        
        else
        return -1;
    }
                
    /**Returns a String representation of all cards on a specified island
     * @param isl - the name of the island
     * @return a String representation of all cards on specified island
     **/
    public String getAllCardsOnIsland(String isl)
    {
        String s = "\nCards on " + isl + "\n";
        Island island = this.getIsland(isl);
        if(island != null)
        {
                s += island.listCards();
                return s;
        } 
        else
        s += "No cards found\n";
        return s;
    } 

    
     /**Returns true if a Card is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the card  >= the rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits (a journey costs 3 credits)
     * AND the card is currently in the source island 
     * AND the card id and ferry code represent objects in the system
     * @param cdId is the id of the card requesting the move
     * @param ferCode is the code of the ferry journey by which the card wants to move
     * @return true if the card is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {   
        Card card = this.getCard(cdId) ;
        Ferry ferry = this.getFerry(ferCode);      
        if(card!=null && ferry!=null)
        return (ferry.canUseFerry(card));
        else        
        return false;

    }     

    /**Returns the result of a card requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source island
     * AND both the card id and the ferry code is on the system
     * If the ferry journey can be made, the card is removed from the source island,
     * added to the destination island and a suitable message returned. Card 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param ferCode is the code of the ferry by which the card wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String ferCode )
    {   //other checks optional

         String s = "";
        Card card = this.getCard(pCardId) ;
        Ferry ferry = this.getFerry(ferCode);        
        if(card!=null && ferry!=null)
        s = ferry.processTransaction(card);
        else if(card==null)
        s = "No such card found";
        else
        s = "No such ferry found.";
        return s;
    } 
         
    /** Allows credits to be added to a card.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits to be added to card 
     */
    public void topUpCredits(int id, int creds)
    {
        Card card = this.getCard(id);
        if(card!=null)  
        card.addCredits(creds);
    }
    
    /** Converts a card's journey points into credits
     * @param id the id of the card whose points are to be converted
     */
    public void convertPoints(int id)  
    {
        Card card = this.getCard(id);
        if(card!=null)  
        card.convertJPCs();
        
   
    } 

    //***************private methods**************
    private void loadCards()
    {
        this.listCards = new ArrayList<>();
        
        Card card1 = new Card(1000,"Lynn",5,10);
        Card card2 = new Card(1001, "May", 3,30);
        Card card3 = new Card(1002, "Nils", 10,0);
        Card card4 = new Card(1003, "Olek", 1,12);
        Card card5 = new Card(1004, "Pan", 3,3);
        Card card6 = new Card(1005, "Quin", 1,30);
        Card card7 = new Card(1006, "Raj", 4,5);
        Card card8 = new Card(1007, "Sol", 7,20);
        Card card9 = new Card(1008, "Tel", 6,30);
        
        
        //Card tour1 = new TouristCard(1010, "Jimmy", 6, 33, "American");
        //Card bus2 = new BusinessCard(1012, "Joe", 6);
        //Card emp3 = new EmployeeCard(1013, "Kenny", 22, "Gardener");
        
        this.listCards.add(card1);
        this.listCards.add(card2);
        this.listCards.add(card3);
        this.listCards.add(card4);
        this.listCards.add(card5);
        this.listCards.add(card6);
        this.listCards.add(card7);
        this.listCards.add(card8);
        this.listCards.add(card9);
        
        //this.cards.add(tour1);
        //this.cards.add(bus2);
        //this.cards.add(emp3);

    }
    
    private void loadIslandsAndFerries()
    {
        this.listIslands = new ArrayList<>();
        
        Island island1 = new Island(0,"Base",0,100);
        Island island2 = new Island(1,"Yorkie",1,100);
        Island island3 = new Island(2,"Bounty",3,10);
        Island island4 = new Island(3,"Twirl",5,2);
        Island island5 = new Island(4, "Aero", 1, 1);
        
        this.listIslands.add(island1);
        this.listIslands.add(island2);
        this.listIslands.add(island3);
        this.listIslands.add(island4);
        this.listIslands.add(island5);        
        
        this.listFerries = new ArrayList<>();
        
        Ferry ferry1 = new Ferry("ABC1", island1, island2);
        Ferry ferry2 = new Ferry("BCD2", island2, island1);
        Ferry ferry3 = new Ferry("CDE3", island2, island3);
        Ferry ferry4 = new Ferry("DEF4", island3, island2);
        Ferry ferry5 = new Ferry("EFG5", island4, island2);
        Ferry ferry6 = new Ferry("GHJ6", island2, island5);
        Ferry ferry7 = new Ferry("HJK7", island5, island2);
        Ferry ferry8 = new Ferry("JKL8", island3, island4);
        
        this.listFerries.add(ferry1);
        this.listFerries.add(ferry2);
        this.listFerries.add(ferry3);
        this.listFerries.add(ferry4);
        this.listFerries.add(ferry5);
        this.listFerries.add(ferry6);
        this.listFerries.add(ferry7);
        this.listFerries.add(ferry8);
        
    }
  
    /** Returns the card with the card id specified by the parameter
     * @param id card id
     * @return the card with the specified name
     **/
    private Card getCard(int id)
    {
  
        for(Card card: this.listCards)
        {
            if(card.getId() == id)
            {
            return card;
            }
        }
        
        return null;
    }
    
    
    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        
         for(Island island : this.listIslands)
        {
            if(island.getName().equals(islandName))
            return island;
        }
        
        return null;
    }
    
    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
       
         for(Ferry ferry : this.listFerries)
        {
            if(ferry.getCode().equals(fer))
            {
            return ferry;
            }
        }       
        return null;
    }
}