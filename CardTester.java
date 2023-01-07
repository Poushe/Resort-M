import java.util.*;
/**
 * Write a description of class CardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardTester
{
    public static void main(String[] args)
    {
       
       
        
        // write your tests here
   
       Card card1 = new Card(1, "Nik", 3, 11);
       Card card2 = new Card(2, "Jack", 1, 2);
       
       
        if(card1.getId()==1)
        {
            System.out.println("Test 1 completed successfully");
        }
        else
        System.out.println("Test 1 failed");
        
        if(card1.getName().equals("Nik"))
        System.out.println("Test 2 completed successfully");
        else
        System.out.println("Test 2 failed");
        
        if(card1.getRating()==3)
        System.out.println("Test 3 completed successfully");
        else
        System.out.println("Test 3 failed");
        
        if(card1.getCredits()==11)
        System.out.println("Test 4 completed successfully");
        else
        System.out.println("Test 4 failed");
        
        card1.addCredits(4);
        if(card1.getCredits()==15)
        System.out.println("Test 5 completed successfully");
        else
        System.out.println("Test 5 failed");
        
        card1.subtractCredits(3);
        if(card1.getCredits()==12)
        System.out.println("Test 6 completed successfully");
        else
        System.out.println("Test 6 failed");
        
        card1.processTransaction();
        
        
        
        if(card1.getCredits()==9)
        System.out.println("Test 7 completed successfully");
        else
        System.out.println("Test 7 failed, Actual credits are: " + card1.getCredits());
        
        
        
        card2.processTransaction();
        
        if(card2.getCredits()==2)
        System.out.println("Test 8 completed successfully");
        else
        System.out.println("Test 8 failed, Actual credits are: " + card2.getCredits());
        
        
        
        card2.convertJPCs();
        
        if(card2.getCredits()==2)
        System.out.println("Test 9 completed successfully");
        else
        System.out.println("Test 9 failed");
        
        
        
        
        
        
        
        
        
    
        
    }
}
