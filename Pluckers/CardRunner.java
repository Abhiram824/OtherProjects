public class CardRunner
{
    public static void main(String[] args)
    {
        RewardsCard card1 = new RewardsCard("Dennis Bonsall");
        RewardsCard card2 = new RewardsCard("Juan Flores");
        RewardsCard card3 = new RewardsCard("Jose Villapando");
        
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        
        card1.recordTransaction(50.00, 0, "09/28/16");
        card1.recordTransaction(36.24, 0, "09/30/16");
        card1.recordTransaction(76.25, 0, "10/04/16");
        card1.recordTransaction(90.00, 10, "10/12/16");
        
        
        System.out.println(card1);
    }
}