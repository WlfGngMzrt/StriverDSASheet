public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,2,3},{4,5,6,7},{10,11,14,18},{21,22,26,26}};
        System.out.println(bruteForce(matrix,10));
        System.out.println(optimizedMethod(matrix,9));
    }

    public static boolean bruteForce(int[][] matrix, int n)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0 ; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == n)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optimizedMethod(int[][] matrix, int n)
    {
        // since we know that the matrix is row wise sorted and the current
        // row first element is greater than the previous row last element
        // the whole matrix can be treated like one sorted array
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = (row*col) - 1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(matrix[mid/col][mid%col] == n)
            {
                return true;
            }
            if(matrix[mid/col][mid%col] > n)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
    }

}