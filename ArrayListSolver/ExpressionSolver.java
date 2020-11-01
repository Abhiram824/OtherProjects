import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.*;
import static java.lang.System.*;

public class ExpressionSolver
{
    private String expression;
    private ArrayList <String> operations;
    private String finalAnswer = "";

    public ExpressionSolver(String s)
    {

        setExpression(s);
    }

    public void setExpression(String s)
    {
        expression = s;
        operations = new ArrayList <String>(); 
        Scanner foo = new Scanner(expression);
        while(foo.hasNext())
        {
            operations.add(foo.next());
        }
        
    }

    public void solveExpression()
    {
        System.out.println(operations);
        for (int i = 1; i < operations.size(); i+= 2)
        {
            if(operations.get(i).equals("/"))
            {
                String z = operations.get(i-1);
                String q = operations.get(i+1);
                int answer  = Integer.parseInt(z)/Integer.parseInt(q);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.add(i-1, Integer.toString(answer));
                i-=2;
                System.out.println(operations);
            }
            else if(operations.get(i).equals("*"))
            {
                String z = operations.get(i-1);
                String q = operations.get(i+1);
                int answer  = Integer.parseInt(z) * Integer.parseInt(q);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.add(i-1, Integer.toString(answer));
                i-=2;
                System.out.println(operations);
            }
            else if(operations.get(i).equals("%"))
                {
                    String z = operations.get(i-1);
                    String q = operations.get(i+1);
                    int answer  = Integer.parseInt(z) % Integer.parseInt(q);
                    operations.remove(i - 1);
                    operations.remove(i - 1);
                    operations.remove(i - 1);
                    operations.add(i-1, Integer.toString(answer));
                    i-=2;
                    System.out.println(operations);
                }
        }
        
        for (int i = 1; i < operations.size(); i+= 2)
        {
            if(operations.get(i).equals("+"))
            {
                String z = operations.get(i-1);
                String q = operations.get(i+1);
                int answer  = Integer.parseInt(z) + Integer.parseInt(q);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.add(i-1, Integer.toString(answer));
                i-=2;
                System.out.println(operations);
            }
            else if(operations.get(i).equals("-"))
            {
                String z = operations.get(i-1);
                String q = operations.get(i+1);
                int answer  = Integer.parseInt(z) - Integer.parseInt(q);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.remove(i - 1);
                operations.add(i-1, Integer.toString(answer));
                i-=2;
                System.out.println(operations);
            }
            
        }
        finalAnswer = operations.get(0);
    }

    public String toString( )
    {
        
        return expression + " = " + finalAnswer + "\n";
    }
}