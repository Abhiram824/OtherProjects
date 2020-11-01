public class PepperPlant
{
    private int maturity, maturityRate, fruitMaturity, fruitMaturityRate, growthRate, waterLevel, nitroLevel, fruitNum;
    private double height;
    public String color, pepperName;
    boolean alive;
    //Don't forget to write the comments when you are done
    
    public PepperPlant(int mRate, int fRate, int gRate, String pName)
    {
       //this is my one and only constructor, either the variables are initialized as a default number because they are static or they are changed based on parameters unique to the pepper
       maturity = 0;
       maturityRate = mRate;
       fruitMaturity = 0;
       fruitMaturityRate = fRate;
       growthRate = gRate;
       waterLevel = 5;
       nitroLevel = 5;
       fruitNum = 0;
       height = 1.5;
       color = "No peppers yet";
       pepperName = pName;
       alive = true;
    }
    
    public void setWaterLevel (int w)
    {
        // in case I ever need to change the water level during a method
        waterLevel = w; 
    }
    public void setAlive ()
    {
        // in case I ever need to change the alive during a method
        if (waterLevel <= 0 || nitroLevel <= 0 || waterLevel >= 10 || nitroLevel >= 10 || maturity >= 100)
        {
            alive = false;
        }
        else
        {
            alive = true;
        }
    }
    public void setNitroLevel(int n)
    {
        // in case I ever need to change the nitro level during a method
        nitroLevel = n;
    }
    public void setColor(String c)
    {
        // in case I ever need to change the color during a method
        color = c;
    }
    public void setHeight(int h)
    {
        // in case I ever need to change the height during a method
        height = h;
    }
    public void setName(String s)
    { 
        // in case I ever need to change the name during a method        
        pepperName = s;
    }
    
    public int getWaterLevel()
    {
        // in case I ever need to get or return the water level during a method or in the main
        return waterLevel;
    }
    public boolean getAlive ()
    {
        // in case I ever need to get or return the alive during a method or in the main
        return alive;
    }
    public int getNitroLevel()
    {
        // in case I ever need to get or return the nitro level during a method or in the main
        return nitroLevel;
    }
    public String getColor()
    {
        // in case I ever need to get or return the color during a method or in the main
        return color;
    }
    public double getHeight()
    {
        //in case I ever need to get or return the height during a method or in the main
        return height;
    }
    public String getName()
    {
       // in case I ever need to get or return the name during a method or in the main
        return pepperName;
    }
    
    
    public String grow()
    {
        //this method simulates the growth of the plant. It increases the plants maturity, might give the plant fruits of a certain color at a more than 50 maturity, and uses 1 water and nitro
        // the plant will die if maturity goes above 100
        setAlive();
        waterLevel--;
        nitroLevel --;
        maturity += maturityRate;
        height += growthRate;
        if(maturity >= 50)
        {
            fruitMaturity += fruitMaturityRate;
            fruitNum = 1 + (int) (Math.random() * 10) + fruitNum;
        }
        
         if( fruitMaturity == 0)
        {
            color = "No Peppers Yet";
        }
        else if( fruitMaturity  >= 1 && fruitMaturity <= 3 )
        {
            color = "Green";
        }
        else if( fruitMaturity  >= 4 && fruitMaturity <= 6 )
        {
            color = "Yellow";
        }
        else if( fruitMaturity  >= 7 && fruitMaturity <= 10 )
        {
            color = "Green";
        }
        else if( fruitMaturity > 10)
        {
            color = "rotted";
        }
        if (waterLevel == 0 || nitroLevel == 0 || waterLevel > 10 || nitroLevel > 10 || maturity > 100)
        {
            alive = false;
            return status();
        }
        setAlive();
        return status();
    }
    
    public String addWater (int ounces)
    {
       // adds water based on the number of ounces put within the water parameter. This allows the plant more water to grow. 
       //If water goes above 10 or is at zero, then the plant dies.       
        setAlive();
        waterLevel += ounces;
        if (waterLevel == 0 || nitroLevel == 0 || waterLevel > 10 || nitroLevel > 10 || maturity > 100)
        {
            alive = false;
            return status();
        }
        setAlive();
        return status();
        
    }
    
    public String addFertilizer (int nitroOunces)
    {
       // adds fertilizer based on the number of ounces put within the fertilizer parameter. This allows the plant more fertilizer to grow. 
       //If fertilizer goes above 10 or is at zero, then the plant dies.
       setAlive();
       nitroLevel += nitroOunces;
       if (waterLevel == 0 || nitroLevel == 0)
       {
            alive = false;
       }
       else if ( waterLevel > 10 || nitroLevel > 10 || maturity > 100)
       {
           alive = false;
       }
       return  status(); 
    }
    
    public String pickFruit()
    {
        //this methods picks the fruits from the plant
        //after picking the pepper fruit number and maturity is set to zero
        setAlive();
        int pickNum = fruitNum;
        String color2 = color;
         
         if(!(getAlive()))
        {
            return "\nYour Plant is Dead\n";
        }
        else if (fruitNum >= 1 && fruitMaturity >= 1)
        {
            fruitMaturity = 0;
            fruitNum = 0;
            color = "no peppers yet";
            return "Picking peppers that are color, " + color2 + " , quantity = " + pickNum + "\n\n" + status();
            
        }
        setAlive();
        return "Picking no peppers yet, quantity = 0\n\n" + status();        
    }
    
    public String status()
    {
        // this is the status. The status shows the status of the plant based on if it is dead or alive
        if(alive)
        {
            return pepperName + "\n\nPlant Maturity: " + maturity + "\nFruit Maturity: " + fruitMaturity + "\nHeight: " + height + "\nWater Level: " + waterLevel + "\nNitro Level: " + nitroLevel + "\nFruit Number: " + fruitNum + "\nFruit Color: " + color + "\n";
        }
        return  "\nYour Plant is dead\n";
    }
    public String data()
     {
        // this is the data. The data shows the status of the plant based on if it is dead or alive        
         if(alive)
        {
            return "Pepper name: " + pepperName + "\nGrowth rate: " + growthRate + "\nMaturity Rate: " + maturityRate + "\nFruit Maturity Rate: " + fruitMaturityRate + "\n\n" + pepperName + "\nPlant Maturity: " + maturity 
            + "\nFruit Maturity: " + fruitMaturity + "\nHeight: " + height + "\nWater Level: " + waterLevel + "\nNitro Level: " + nitroLevel + "\nFruit Number: " + fruitNum + "\nFruit Color: " + color + "\n";
        }
        return  "\nYour Plant is dead\n"; 
    }
    public String Quit ()
    {
        //this is the quit method which allows the user to leave the program and leaves by displaying the status
        return status();      
    }
    public String toString()
    {
        // this is the toString and siplays the print of the class and explains the pepper 
        return "your pepper: " + pepperName + " has a status of\n\n" + status();
    }
      
    }
    