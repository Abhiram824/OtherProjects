import java.lang.Integer;
/** 
 * 
 * VERY IMPORTANT: For this assignment only, the only methods and classes from the 
 * Java standard library you may use in your final solutions are:<br>
 * 1. All methods from the System class<br>
 * 2. All methods from the Math class<br>
 * 3. native arrays, including the <tt>arr.length</tt> field and creating and using new native arrays
 */
public class ArrayProject
{

        
    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt> otherwise
     * 
    */
    public static boolean isPermutation(int[] listA, int[] listB) {
        assert (listA != null && listB != null) : "Violation of precondition: isPermutation";
        selSort(listA);
        selSort(listB);
        if(listA.length != listB.length)
            return false;
        for(int i = 0; i < listA.length; i++)
        {
            if(listA[i] != listB[i])
                return false;
        }
        return true;
    }
    public static void selSort(int [] array)
    {
        for(int i = 0; i < array.length-1; i++)
        {
            int bigPos = i;
            for(int k = i+1; k < array.length; k++)
            {
                if(array[bigPos] > array[k])
                {
                    bigPos = k;
                }
            }
            int alias = array[bigPos];
            array[bigPos] = array[i];
            array[i] = alias;
        }
        
    }


    
    

    /**
     * Determine which row or column in a matrix has the largest sum.
     * The parameter <tt>mat</tt> is not altered as a result of
     * this method call.
     * <p>pre: mat != null, mat.length > 0,
     * mat is a rectangular matrix, mat[0].length > 0
     * <p>post: determine which row or column of ints has the maximum sum in max. 
     * If a row contains the maximum sum, return a string starting with "R" and 
     * then the number of the row with no spaces. For example "R0" or "R12". If a 
     * column contains the maximum sum, return a string starting with "C" and then 
     * the number of the column with no spaces. For example "C0" or "C12".  
     * If there is more than one row or column with the maximum sum 
     * return rows over columns first, then smaller indices over
     * larger indices.<br>
     * Thus if rows 3, 5, and 12, and columns 0 and 2 all contained
     * the same maximum sum the method would return "R3".
    */
    public static String maxSum(int[][] mat) {
        assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
                && isRectangular( mat ) : "Violation of precondition: maxSum";
                
        int maxNum = Integer.MIN_VALUE;
        String maxSum = "";
        //START FROM THE END WITH COLUMNS
        for(int r = 0; r < mat.length; r++)
        {
            int count = 0; 
            for(int c = 0; c < mat[r].length; c++)
            {
                count += mat[r][c];
            }
            if(count > maxNum)
            {
                maxNum = count;
                maxSum = "R" + r;
            }
        }
        for(int col = 0; col < mat[0].length; col++)
        {
            int count2 = 0; 
            for(int row = 0; row < mat.length; row++)
            {
                count2 += mat[row][col];
            }
            if(count2 > maxNum)
            {
                maxNum = count2;
                maxSum = "C" + col;
                
            }
        }
        
        
        return maxSum; 
    }
    
    

    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
    */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        assert (board != null) && (board.length > 0)
                && isSquare(board) && onlyContains(board, validChars)
                : "Violation of precondition: queensAreSafe";
        boolean result = true;      
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                if(board[r][c] == 'q')
                {
                    if(!(checkSafe(board, r,c)))
                        return false;
                } 
                
            }
        }

        return true; //must change
    }
    public static boolean checkSafe(char [][] mat, int row, int col)
    {
        //check diagnolly
        for(int c = 0; c < mat[row].length; c++)
        {
            
            if(mat[row][c] == 'q' && c != col)
            {
                return false;
            }
        }
        for(int r = 0; r < mat.length; r++)
        {
            
            if(mat[r][col] == 'q' && r != row)
            {
                return false;
            }
        }
        int diagRow = row;
        int diagCol = col;
        while(diagRow >0 && diagCol >0)
        {
            diagRow--;
            diagCol--;
            if(mat[diagRow][diagCol]=='q')
            {
                return false;
            }
        }
        diagRow = row;
        diagCol = col;
        while(diagRow < mat.length - 1 && diagCol < mat[0].length - 1)
        {
            diagRow++;
            diagCol++;
            if(mat[diagRow][diagCol]=='q')
            {
                return false;
            }
        }
        diagRow = row;
        diagCol = col;
        while(diagRow > 0 && diagCol < mat[0].length - 1)
        {
            diagRow--;
            diagCol++;
            if(mat[diagRow][diagCol]=='q')
            {
                return false;
            }
                
        }
        diagRow = row;
        diagCol = col;
        while(diagRow < mat.length - 1 && diagCol > 0)
        {
            diagRow++;
            diagCol--;
            if(mat[diagRow][diagCol]=='q')
            {
                return false;
            }
                
            
        }
        return true;
    }

    public static void main(String[] args) {
                            
        //test 1
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        boolean expectedBool = true;
        boolean actualBool = isPermutation(a,b);
        System.out.print("\nTest 1 expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 1, isPermutation");
        else
            System.out.println(" failed test 1, isPermutation");

        //test 1a
        a = new int[]{1, 7, 3};
        b = new int[]{2, 1, 3};
        expectedBool = false;
        actualBool = isPermutation(a,b);
        System.out.print("\nTest 1a expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 1a, isPermutation");
        else
            System.out.println(" failed test 1a, isPermutation");

        //test 1b
        a = new int[]{1, 2, 3, 5, 4, 8};
        b = new int[]{2, 1, 3, 8, 5, 4};
        expectedBool = true;
        actualBool = isPermutation(a,b);
        System.out.print("\nTest 1b expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 1b, isPermutation");
        else
            System.out.println(" failed test 1b, isPermutation");

        //test 1c
        a = new int[]{1, 2, 3};
        b = new int[]{2, 1, 3, 3};
        expectedBool = false;
        actualBool = isPermutation(a,b);
        System.out.print("\nTest 1c expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 1c, isPermutation");
        else
            System.out.println(" failed test 1c, isPermutation");

         //test 2
        char[][] safe = { {'.', '.', '.'},
                          {'q', '.', '.'},
                          {'.', '.', 'q'}};
        expectedBool = true;
        actualBool = queensAreSafe(safe);
        System.out.print("\nTest 2 expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 2, queensAreSafe");
        else
            System.out.println(" failed test 2, queensAreSafe");

        //test 2a
        char[][] unsafe = { {'.', '.', '.', 'q'},
                            {'.', '.', '.', '.'},
                            {'.', '.', '.', '.'},
                            {'q', '.', '.', '.'}};
        expectedBool = false;
        actualBool = queensAreSafe(unsafe);
        System.out.print("\nTest 2a expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 2a, queensAreSafe");
        else
            System.out.println(" failed test 2a, queensAreSafe");

        //test 2b
        char[][] unsafeA = { {'q', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', 'q', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', 'q'},
                            {'.', '.', '.', '.', '.', 'q', '.', '.'},
                            {'.', '.', 'q', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', 'q', '.'},
                            {'.', 'q', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', 'q', '.', '.', '.', '.'}};
        expectedBool = true;
        actualBool = queensAreSafe(unsafeA);
        System.out.print("\nTest 2b expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 2b, queensAreSafe");
        else
            System.out.println(" failed test 2b, queensAreSafe");

        //test 2c
        char[][] unsafeB = { {'.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', 'q', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', 'q'},
                            {'.', '.', '.', '.', '.', 'q', '.', '.'},
                            {'.', '.', '.', 'q', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', 'q', '.'},
                            {'.', 'q', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', 'q', '.', '.', '.', '.'}};
        expectedBool = false;
        actualBool = queensAreSafe(unsafeB);
        System.out.print("\nTest 2c expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 2c, queensAreSafe");
        else
            System.out.println(" failed test 2c, queensAreSafe");
            
        //test 3
        int[][] mat = { {1, 2, 3, 4},
                        {0, 0, 0, 0},
                        {1, 2, 3, 10},
                        {4, 3, 2, 1}};
        String expectedString = "R2";
        String actualString = maxSum(mat);
        System.out.print("\nTest 3 expected value: " + expectedString + ", actual value: " + actualString);
        if( expectedString.equals(actualString) )
            System.out.println(" passed test 3, maxSum");
        else
            System.out.println(" failed test 3, maxSum");
        
        // test 3a
        mat = new int[][] { {-10, -20, -30, -40},
                            {-2, -2, -200, -300},
                            {-200, -2, -300, -100},
                            {-200, -3, -200, -100}};
        expectedString = "C1";
        actualString = maxSum(mat);
        System.out.print("\nTest 3a expected value: " + expectedString + ", actual value: " + actualString);
        if( expectedString.equals(actualString) )
            System.out.println(" passed test 3a, maxSum");
        else
            System.out.println(" failed test 3a, maxSum");
        
        //test 3b
        mat = new int[][] { {1,  2,  3,  4},
                            {2,  0,  0, -1},
                            {3, -2, -2, -1},
                            {4,  2,  3,  1}};
        expectedString = "R0";
        actualString = maxSum(mat);
        System.out.print("\nTest 3b expected value: " + expectedString + ", actual value: " + actualString);
        if( expectedString.equals(actualString) )
            System.out.println(" passed test 3b, maxSum");
        else
            System.out.println(" failed test 3b, maxSum");
      
    }   
    
    /* pre: mat != null
       post: return true if mat is a square matrix, false otherwise
    */
    private static boolean isSquare(char[][] mat) {
        assert mat != null : "Violation of precondition: isSquare";

        final int numRows = mat.length;
        int row = 0;
        boolean square = true;
        while( square && row < numRows ) {
            square = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return square;
    }
    

    /* pre: mat != null, valid != null
       post: return true if all elements in mat are one of the characters in valid
    */
    private static boolean onlyContains(char[][] mat, char[] valid)
    {   assert mat != null && valid != null : "Violation of precondition: onlyContains";

        int row = 0;
        int col;
        boolean correct = true;
        while( correct && row < mat.length) {
            col = 0;
            while(correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }


    /* pre: list != null
       post: return true if c is in list
    */
    private static boolean contains(char[] list, char c) {
        assert ( list != null ) : "Violation of precondition: contains";

        boolean found = false;
        int index = 0;
        while( !found && index < list.length) {
            found = list[index] == c;
            index++;
        }
        return found;
    }


    /*
    /* pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while( correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }
}