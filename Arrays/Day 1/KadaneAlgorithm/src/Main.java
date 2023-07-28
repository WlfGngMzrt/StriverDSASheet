public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }
    //kadane algorithm is used to find out the maximum sub array sum in an array
    public static int bruteForce(int[] arr)
    {
        //[1,2,3,4,5]
        int ans = 0;
        for(int i = 0;i < arr.length; i++)
        {
            int curr_sum = 0;
            for(int j = i ; j < arr.length; j++)
            {
                curr_sum += arr[j];
            }
            ans = Math.max(curr_sum,ans);
        }
        return ans;
    }
    public static int kadaneAlgorithm(int[] arr)
    {
        //we will take the lowest possible sum and the try to iterate through
        //the array in terms of the sum and compare if it's the maximum sum
        // if the sum is zero there cannot be a maximum sum than that
        // make it zero
        //edge case is that there can be an array of negative numbers
        int sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            curr_sum += arr[i];
            sum = Math.max(curr_sum,sum);
            if(curr_sum < 0)
            {
                curr_sum = 0;
            }
        }
        if(sum < 0)
        {
            for(int i = 0; i < arr.length; i++)
            {
                sum += Math.max(sum, arr[i]);
            }
        }
        return sum;
    }

}