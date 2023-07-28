public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{7,1,5,3,6,4,7,6,4,3,1};
        //System.out.println(bruteForce(arr));
        //System.out.println(optimalSolution(arr));
    }
    public static int bruteForce(int[] arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                ans = Math.max(ans,arr[j] - arr[i]);
            }
        }
        return ans;
    }

    public static int optimalSolution(int[] arr)
    {
        //modified version of kadane's algorithm
        // we are interested to buy stock at a minimum rate
        // sell at a maximum rate so we traverse through the array
        // at every index we try to check if it is the best buy, and then
        // we shall store the value and check going forward the profit if
        // it is the maximum that we could have earned
        // the point here is buying at a minimum rate and selling at the next possible
        // high point.
        int max_profit = Integer.MIN_VALUE;
        int min_buy = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length; i++)
        {
            min_buy = Math.min(min_buy,arr[i]);
            max_profit = Math.max(max_profit,arr[i] - min_buy);
        }
        return max_profit;
    }
}