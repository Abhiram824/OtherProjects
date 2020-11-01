import java.util.Arrays;
import java.lang.Math;
public class OrganRunner
{
    public static void main (String [] args)
    {
        Organ [] organList = new Organ [10];
        for (int i = 0; i < 5; i++)
        {
            Organ heart1 = new Heart(giveRand());
            organList[i] = heart1;
        }
        boolean needsOxygen;
        for (int i = 5; i < 10; i++)
        {
            if(giveRand() % 2 == 0)
                needsOxygen = false;
            else
                needsOxygen = true;
            Organ lung = new Lung(needsOxygen);
            organList[i] = lung;
        }
        String function = "";
        for(int i = 0; i < organList.length; i++)
        {
            function += organList[i].function() + "\n";
        }
        System.out.println(function);
    }
    
    public static int giveRand()
    {
        return (int)((Math.random() * 40) + 60);
    }
}