
public class ExpressionRunner
{
    public static void main (String [] args)
    {
        ExpressionSolver solution = new ExpressionSolver("3 + 5");
        solution.solveExpression();
        System.out.println(solution + "\n");
        
        solution = new ExpressionSolver("3 * 5");
        solution.solveExpression();
        System.out.println(solution + "\n");
        
        solution = new ExpressionSolver("3 - 5");
        solution.solveExpression();
        System.out.println(solution + "\n");
        
        solution = new ExpressionSolver("3 / 5");
        solution.solveExpression();
        System.out.println(solution + "\n");
        
        solution = new ExpressionSolver("5 / 5 * 2 + 8 / 2 + 5");
        solution.solveExpression();
        System.out.println(solution + "\n");
        
        solution = new ExpressionSolver("5 * 5 + 2 / 2 - 8 + 5 * 5 - 2");
        solution.solveExpression();
        System.out.println(solution);
        
        //retype the minus signs manually    
    }
    
    
}
