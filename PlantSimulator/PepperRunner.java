import java.util.Scanner;
import java.util.Arrays;
public class PepperRunner
{
    public static void main (String args [])
    {
        //this is the main method where the scanner exists and the actual pepper plant growth is simulated from the class
        PepperPlant [] pepperList = createArrays();
        System.out.println("Number of peppers to simulate growth: 5");
        for (int i = 0; i < pepperList.length; i++)
        {
            System.out.println(i + " " + pepperList[i].getName());
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Select the pepper that you want to simulate the growth of: ");
        int pNum = keyboard.nextInt(); 
        System.out.print("");
        String answer = keyboard.nextLine();
        while(!(answer.equals("q")))
        {
           
            if(answer.equals("d"))
           {
                System.out.println("\n\n" + pepperList[pNum].data());
           }
           else if(answer.equals("g"))
            {
               if(pepperList[pNum].getAlive())
               {
                int day = 0;
                day++;
                System.out.print("\n\nGrowing Plant Day " + day + "\n\n" + pepperList[pNum].grow()); 
               }
               else
               {
                   System.out.print("\nYour Plant is Dead\n"); 
               
               }
            }
            else if(answer.equals("w"))
            {
                if(pepperList[pNum].getAlive())
               {
                System.out.print("\n\nHow many ounces of water did you add: ");
                int water = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("\nWatering plant for " + water + " ounces\n\n" + pepperList[pNum].addWater(water));
               }
               
               else
               {
                  System.out.print("\nYour Plant is Dead\n"); 
               }
                
            
            }
            else if(answer.equals("f"))
            {
                if(pepperList[pNum].getAlive())
               {
                System.out.print("\n\nHow many ounces of fertlizer did you add: ");
                int fertilizer = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("\nFertilizing plant for " + fertilizer + " ounces\n\n" + pepperList[pNum].addFertilizer(fertilizer));  
               }
               else
               {
                  System.out.print("\nYour Plant is Dead\n"); 
               }
            }
            else if(answer.equals("p"))
           {   
               System.out.print("\n\n" + pepperList[pNum].pickFruit());
               
           }
            else if(answer.equals("s"))
            {
                System.out.print("\n\n" + pepperList[pNum].status());
                
             
            }
           
           System.out.print("\nPepper: Data <d>, Grow<g>, Water<w>, Fertilizer<f>, Pick<p>, Status<s> or Quit<q>: ");
           answer = keyboard.nextLine();
        }
        if (answer.equals("q"))
            {
               System.out.println(pepperList[pNum].Quit() + "\n\nGoodbye!");  
               
            }
        
  }
  public static PepperPlant[] createArrays()
  {
      //this is a method that is static and creates the array of peppers
      PepperPlant[] pepperList = new PepperPlant [5];
      pepperList[0] = new PepperPlant (25, 2, 5, "Bell Pepper");
      pepperList[1] = new PepperPlant (17, 3, 4, "Serrano Pepper");
      pepperList[2] = new PepperPlant (33, 4, 7, "Ghost Pepper");
      pepperList[3] = new PepperPlant (14, 1, 5, "Chilli Pepper");
      pepperList[4] = new PepperPlant (28, 4, 6, "Poblano Pepper");
      return pepperList;
      
  }
}
 