public class Lung extends Organ
{
    private boolean needsOxygen;
    
    public Lung(boolean n)
    {
        super(true, "respiratory", 2.9, "lungs");
        needsOxygen = n;
    }
    
    
    public String function()
    {
        return "The lung supplies oxygen to blood and discards carbon dioxide waste";
    }
    
    public void setOxygen (boolean o)
    {
        needsOxygen = o;
    }
    public boolean getOxygen()
    {
        return needsOxygen;
    }
    
    public String toString()
    {
        return super.toString() + "\nNeeds Oxygen = " + needsOxygen;
    }
}