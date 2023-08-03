public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int bruteForce(int n, int m)
    {
        //this is the most brute force way to find the solution
        if(m == 0 && n == 0)
        {
            return 1;
        }
        if(m == 0 || n == 0)
        {
            return 0;
        }
        return bruteForce(n-1,m) + bruteForce(n,m-1);
    }

    public static int optimisedApproach(int n, int m, int[][] dp) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (dp[n][m] == -1)
        {
            dp[n][m] = optimisedApproach(n-1,m,dp) + optimisedApproach(n,m-1,dp);
        }
        return dp[n][m];
    }
}