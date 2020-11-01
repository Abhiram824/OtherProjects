

public class RewardsCard
{
    private String name;
    private static int IDNum = 1;
    private Transaction [] purchaseHistory;
    private int points;
    private int transactionNum;
    public RewardsCard(String n)
    {
        name = n;
        IDNum++;
        transactionNum = 0;
    }
    
    public int getIDNum()
    {
        return IDNum;
    }
    
    public void setPoints(int p)
    {
        points = p;
    }
    public int getPoints()
    {
        return points;
    }
    
    public void recordTransaction (double price, int pointsUsed, String date)
    {
        Transaction trans1 = new Transaction(price, pointsUsed, date);
        purchaseHistory[transactionNum] = trans1;
        transactionNum++;
        points -= pointsUsed;
        points += .1 *(price - pointsUsed);
    }
    public Transaction [] getPurchaseHistory()
    {
        return purchaseHistory;
    }
    
    public void printPurchaseHistory (Transaction array [])
    {
        String purchase = "";
        for (int i = 0; i< array.length; i++)
        {
            purchase = array[i].getDate() + "\t" + array[i].getPrice() + "\t" + array[i].getPointsUsed() + "\t" + (.1 * array[i].getPrice()) + "\n";
        }
    }
    public String toString ()
    {
        return "This Plucker's card belongs to " + name + "\nAccount Number is: " + IDNum + "\nTheir current rewards points are " + points + " Their purchase history is:\n  date\t" ;
    }
}
