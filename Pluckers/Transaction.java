public class Transaction
{
    private double price;
    private int pointsUsed;
    private String date;
    public Transaction(double p, int pU, String d)
    {
        price = p;
        pointsUsed = pU;
        date = d;
    }
    
    public void setPointsUsed (int pU)
    {
        pointsUsed += pU;
    }
    public int getPointsUsed()
    {
        return pointsUsed;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public double getPrice()
    {
        return price;
    }
}