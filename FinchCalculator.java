package CalProject;


import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchCalculator
{
   public static void main(final String[] args)
    {
      Finch myFinch = new Finch();
      while(!myFinch.isBeakUp())
      {
          myFinch.sleep(1000);
      } 
      int x = Input(myFinch);
      
      while(!myFinch.isBeakUp())
      {
          myFinch.sleep(1000);
      }
      
      int y = Input(myFinch);
      
      while(!myFinch.isBeakUp() && !myFinch.isBeakDown() && !myFinch.isLeftWingDown() && !myFinch.isRightWingDown())
      {
            myFinch.sleep(100);
      }

      
      
      if(myFinch.isBeakUp())
      {
          Addition(myFinch,x,y);
              
      }
      if(myFinch.isLeftWingDown())
      {
          Subtraction(myFinch,x,y);
              
      }
      if(myFinch.isBeakDown())
      {
          Division(myFinch,x,y);
      }
      if(myFinch.isRightWingDown())
      { 
          Multiplication(myFinch,x,y);
      }
      
      

      
      myFinch.sleep(1000);      

  
      myFinch.quit();
      System.exit(0);
    }
   public static int Input (Finch myFinch)
   {
        int i = 0;
        while(myFinch.isBeakUp() && i <= 5)
        {
            
            myFinch.setLED(255,0,0,1000);
            i++; 
            myFinch.sleep(500);
            
        }
        return i;
   }
   public static void Addition(Finch myFinch, int numOne, int numTwo)
   {
       int add = numOne + numTwo;
       for (int i = 0; i < add; i++)
       {
           myFinch.setLED(255,0,0,1000);   
           myFinch.sleep(500);
       }
   }
   public static void Subtraction (Finch myFinch, int numOne, int numTwo)
   {
       int sub = numOne - numTwo;
       if(sub >= 0)
       {
           for (int i = 0; i < sub; i++)
          {
            myFinch.setLED(255,0,0,1000);   
            myFinch.sleep(500);
          }  
       }
       else
       {
           for (int i = 0; i > sub; i--)
          {
            myFinch.setLED(0,255,0,1000);   
            myFinch.sleep(500);
          }
       }
       
   }
   public static void Division (Finch myFinch, int numOne, int numTwo)
   {
       int div = numOne/numTwo;
       for (int i = 0; i < div; i++)
       {
           myFinch.setLED(255,0,0,1000);   
           myFinch.sleep(500);
       }
   }
   public static void Multiplication (Finch myFinch, int numOne, int numTwo)
   {
       int mult = numOne * numTwo;
       for (int i = 0; i < mult; i++)
       {
           myFinch.setLED(255,0,0,1000);   
           myFinch.sleep(500);
       }
   }
}