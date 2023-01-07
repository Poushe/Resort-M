import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{  
    private Scanner reader = new Scanner(System.in);
    private WIRE wayward = new Resort("Wayward Islands");
    
    private void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllResort();}
            else if (choice == 2){listAllCards();}
            else if (choice == 3){listOneIsland();}
            else if (choice == 4){findLocationOfCard();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){viewCard();}
            else if (choice == 8){updateCredits();}                        
            else if (choice == 9){convertPts();}

            // output menu & get choice
            
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all cards on all islands");
        System.out.println("3. List all cards on one island");
        System.out.println("4. Find location of card");
        System.out.println("5. Say if card can move by ferry");
        System.out.println("6. Move a card by ferry");
        System.out.println("7. View card");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");

        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }
    
    // This one has been done for you 
    private void listAllResort()
    {
        System.out.println(wayward.toString());
    }
    
    // provide the code here  
    private void listAllCards()
    {
        
    }
   
    // provide the code here 
    private void listOneIsland()
    {
        
    }
       
    // This one has been done for you
    private void findLocationOfCard()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        String ww = wayward.findCardLocation(trav);
        if(ww != null)
        {
            System.out.println(ww);
        }
        else
        {
            System.out.println("No such card");
        }
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(wayward.canTravel(trav,ferry));
    }
    
    // provide the code here
    private void travelNow()
    {
        
 
    }
    
    // This one has been done for you
    private void viewCard()
    {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        System.out.println(wayward.viewACard(cId));
    }
     
    // provide the code here
    private void updateCredits()
    {
        
              
    }
         
    // This one has been done for you
    private void convertPts()
    {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        wayward.convertPoints(cId);
    }   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
    
}
