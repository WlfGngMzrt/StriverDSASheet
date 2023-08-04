import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,5,8,11};
        int target = 14;


    }
    public static boolean bruteForceVariant1(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] + arr[j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static int[] bruteForceVariant2(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] + arr[j] == target)
                {
                    int[] ans = new int[2];
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    return ans;
                }
            }
        }
        return new int[]{-1,-1};
    }


    public static boolean betterApproachVariant1(int[] arr, int target)
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length; i++)
        {
            int compliment = target - arr[i];
            if(hm.containsKey(compliment))
            {
                return true;
            }
            hm.put(arr[i],i);
        }
        return false;
    }

    public static int[] betterApproachVariant2(int[] arr, int target)
    {
        int[] ans = new int[]{-1,-1};
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length; i++)
        {
           int compliment = target - arr[i];
           if(hm.containsKey(compliment))
           {
               arr[0] = hm.get(arr[i]);
               arr[1] = hm.get(compliment);
               return arr;
           }
           hm.put(arr[i],i);
        }
        return arr;
    }
    public static boolean optimizedApproach(int[] arr, int target)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length;
        while(i < j)
        {
            if(arr[i] + arr[j] == target)
            {
                return true;
            }

            if(arr[i] + arr[j] < target)
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        return false;
    }

}