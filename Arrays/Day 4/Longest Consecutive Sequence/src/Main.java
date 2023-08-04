import java.util.Arrays;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{100,200,1,2,4,3,101,201,202};
        System.out.println("Brute force : " + bruteForce(arr));
        System.out.println("Better : " + betterApproach(arr));
        System.out.println("Optimised : " + optimisedApproach(arr));
    }
    public static int bruteForce(int[] arr)
    {
        // here the brute force encompasses the way of finding the next element
        // consequently for the number x -> x+1
        // we can implement this is such a way that we can take one element and
        // check for its count for all the possible next elements
        int result = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++)
        {
            int curr = arr[i];
            int count = 1;
            while(linearSearch(arr,curr+1))
            {
                curr += 1;
                count+= 1;
            }
            result = Math.max(result,count);
        }
        return result;
    }
    public static boolean linearSearch(int[] arr, int target)
    {
        for(int i = 0;i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                return true;
            }
        }
        return false;
    }
    public static int betterApproach(int[] arr)
    {
        // here we follow the sorting method approach
        int result = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int curr = 0,prev =arr[0], count = 1;
        // now we shall check the longest sequence possible
        for(int i = 1;i < arr.length; i++)
        {
            curr = arr[i];
            if(curr == prev)
            {
                continue;
            }
            if(curr == prev + 1)
            {
                count++;
                result = Math.max(count,result);
            }
            else if(curr != prev + 1)
            {
                count = 1;
            }
            prev = arr[i];
        }
        return result;
    }
    public static int optimisedApproach(int[] arr) {
        int n = arr.length;
        if (n == 0)
        {
            return 0;
        }
        int longest = 1;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0;i < n; i++)
        {
            hs.add(arr[i]);
        }
        for(int it : hs)
        {
            if(!hs.contains(it - 1))
            {
                int cnt = 1;
                int x = it;
                while (hs.contains(x + 1))
                {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest,cnt);
            }
        }
        return longest;
    }
}