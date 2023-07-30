public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //matrix = bruteForce(matrix);
        optimalMethod(matrix);
        printMatrix(matrix);

    }
    public static int[][] bruteForce(int[][] matrix)
    {
        //TC : O(N*M)
        //SC : O(N*M)
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dummyMatrix = new int[n][m];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++)
            {
                dummyMatrix[j][n-i-1] = matrix[i][j];
            }
        }
        return dummyMatrix;
    }
    public static void optimalMethod(int[][] matrix)
    {
        transpose(matrix);
        printMatrix(matrix);
        clockWiseRotate(matrix);
    }

    public static void clockWiseRotate(int[][] matrix)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            arrayReversal(matrix[i]);
        }
    }
    public static void transpose(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = i+1; j < matrix[0].length; j++)
            {
                swap(i,j,matrix);
            }
        }
    }
    public static void swap(int i, int j, int[][] matrix)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public static void swapCols(int col, int i, int j, int[][] matrix)
    {
        int temp = matrix[i][col];
        matrix[i][col] = matrix[j][col];
        matrix[j][col] = temp;
    }
    public static void arrayReversal(int[] arr)
    {
        int s = 0;
        int e = arr.length - 1;
        while(s < e)
        {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public static void printMatrix(int[][] matrix)
    {
        for(int[] i : matrix)
        {
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }



}