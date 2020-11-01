public abstract class Organ
{
    private boolean vital;
    private String organSystem;
    private String name;
    private double pounds;
    
    public Organ()
    {
        vital = false;
        organSystem = "";
        pounds = 0.0;
        name = "";
    }
    public Organ(boolean b, String o, double w, String n)
    {
        vital = b;
        organSystem = o;
        pounds = w;
        name = n;
    }
    
    public boolean getVital()
    {
        return vital;
    }
    public String getOrgan()
    {
        return name;
    }
    public String getSystem()
    {
        return organSystem;
    }
    public double getPounds()
    {
        return pounds;
    }
    
    public void setVital(boolean b)
    {
        vital = b;
    }
    public void setSystem(String o)
    {
        organSystem = o;
    }
    public void setName(String n)
    {
        name = n;
    }
    public void setPounds (double w)
    {
        pounds = w;
    }
    
    public abstract String function();
    
    public String toString()
    {
        return name + " data: " + "\nvital = " + vital + "\nweight = " + pounds + "\nSystem = " + organSystem;
    }
  
}