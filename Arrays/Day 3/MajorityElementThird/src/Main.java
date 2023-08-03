import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = new int[]{11, 33, 33, 11, 33, 11};
        System.out.println(bruteForce(arr));
        System.out.println(betterApproach((arr)));
        System.out.println(optimisedMethod(arr));
    }
    public static ArrayList<Integer> bruteForce(int[] arr)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < arr.length; i++)
        {
            int count = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                {
                    count++;
                }
                if(count > arr.length/3 && !ans.contains(arr[j]))
                {
                    ans.add(arr[j]);
                    break;
                }
            }
            if(ans.size() == 2)
            {
                break;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> betterApproach(int[] nums)
    {
        int N = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0 ;i < nums.length; i++)
        {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
                if (hm.get(nums[i]) > N / 3) {
                    ans.add(nums[i]);
                }
            }
            else
            {
                hm.put(nums[i],1);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> optimisedMethod(int[] nums)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int majority1 = nums[0];
        int count1 = 1;
        int majority2 = nums[1];
        int count2 = 1;
        int N = nums.length/3;
        for(int i = 2; i < nums.length; i++)
        {
            if(count1 == 0 && nums[i] != majority2)
            {
                majority1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && nums[i] != majority1)
            {
                majority2 = nums[i];
                count2 = 1;
            }
            if(nums[i] == majority1)
            {
                count1++;
            }
            if(nums[i] == majority2)
            {
                count2++;
            }
            count1--;
            count2--;
        }
        int verify1 = 0;
        int verify2 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == majority1)
            {
                verify1++;
            }
            if(nums[i] == majority2)
            {
                verify2++;
            }
        }
        if(verify1 > N/3 && verify2 > N/3)
        {
            ans.add(majority1);
            ans.add(majority2);
        }
        return ans;
    }



}