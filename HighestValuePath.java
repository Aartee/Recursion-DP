/* Java program for Dynamic Programming implementation
   of Min Cost Path problem */
import java.util.*;
 
class HighestValuePath
{
    /* A utility function that returns minimum of 3 integers */
    private static int max(int x, int y, int z)
    {
        if (x > y)
            return (x > z)? x : z;
        else
            return (y > z)? y : z;
    }
 
    private static int highValuePath(int value[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = value[0][0];
 
        /* Initialize first column of total value(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + value[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + value[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = max(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + value[i][j];
 
        return tc[m][n];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int value[][]= {{3, 4, 9, 3},
                       {6, 3, 1, 4},
                       {8, 5, 4, 5},
                       {4, 9, 8, 2},
                       {7, 2, 0, 4}};
        System.out.println("maximum value of path (4,3) = " + highValuePath(value,4,3));
    }
}
