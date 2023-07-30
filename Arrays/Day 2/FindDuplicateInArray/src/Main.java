import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{2,3,4,5,6,9,8,7,6,1};
        System.out.println(optimisedApproach2(arr);


    }

    public static int bruteForce(int[] arr)
    {
        //we can just sort the array, iterate over sorted array and find the duplicate
        //TC :O(NLogN)
        //SC :O(1)

        Arrays.sort(arr);
        for(int i = 1;i < arr.length; i++)
        {
            if(arr[i-1] == arr[i])
            {
                return arr[i];
            }
        }

        return -1;
    }
    public static int optimalApproach1(int[] arr)
    {
        //TC : O(N)
        //SC : O(N)
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i =0; i < arr.length; i++)
        {
            if(hs.contains(arr[i]))
            {
                return arr[i];
            }
            else
            {
                hs.add(arr[i]);
            }
        }
        return -1;
    }

    public static void optimisedApproach2(int[] arr)
    {
        //this approach follows the method of linked list principle
        //since one element has been occuring twice it will definitely
        //lead to the creation of a cycle. This will allow us to find out
        //as we can apply the concept of finding where the cycle has started.
        int slow = arr[0];
        int fast = arr[0];
        while(slow != fast)
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = arr[0];
        while(slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
    }
}