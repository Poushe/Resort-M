
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        WIRE wayward = new Resort("Wayward Islands");
        Scanner enter = new Scanner(System.in);
        
        // Write all of your tests here
        //Test 1
        if(wayward.findCardLocation(1005).equals("Base"))
        System.out.println("Test 1 passed");
        else
        System.out.println("Test 1 failed");
        
        //Test 2
        if(wayward.getIslandNumber("Yorkie")==1)
        System.out.println("Test 2 passed");
        else
        System.out.println("Test 2 failed");
        
        //Test 3
        if(wayward.canTravel(1001,"ABC1"))
        System.out.println("Test 3 passed");
        else
        System.out.println("Test 3 failed");
        
        //Test 4
        if(!wayward.canTravel(1003,"CDE4"))
        System.out.println("Test 4 passed");
        else
        System.out.println("Test 4 failed");
           
        
        //Test 5
        wayward.travel(1002,"ABC1");
        if(wayward.findCardLocation(1002).equals("Yorkie"))
        System.out.println("Test 5 passed");
        else
        System.out.println("Test 5 failed");
           
    }
    
    // No need to change this
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
