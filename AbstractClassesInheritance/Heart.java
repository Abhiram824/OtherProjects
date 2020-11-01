public class Heart extends Organ
{
    private int heartRate;

    
    public Heart(int h)
    {
        super(true, "circulatory", 0.8, "heart");
        heartRate = h;
    }
    
    public void setRate(int r)
    {
        heartRate = r;
    }
    public int getRate ()
    {
        return heartRate;
    }
    
    public String function()
    {
        return "The heart circulates blood throughout the body";
    }
    
    public String toString()
    {
        return super.toString() + "\nheart rate = " + heartRate;
    }

    
}