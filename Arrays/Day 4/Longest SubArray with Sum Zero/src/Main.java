import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{9, -3, 3, -1, 6, -5};
        System.out.println(bruteForce(arr));
        System.out.println();
    }
    public static int bruteForce(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++)
        {
            int curr_sum = 0;
            for(int j = i; j < arr.length; j++)
            {
                curr_sum += arr[j];
                if(curr_sum == 0)
                {
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public static int optimizedApproach(int[] arr)
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            pf[i] = pf[i-1] + arr[i];
        }
        int maxLen  = 0;
        for(int i = 0; i < pf.length; i++)
        {
            if(pf[i] == 0)
            {
                maxLen = Math.max(i+1,maxLen);
                continue;
            }
            if(hm.containsKey(pf[i]))
            {
                maxLen = Math.max(maxLen,i - hm.get(pf[i]));
            }
            else
            {
                hm.put(pf[i],i);
            }
        }
        return maxLen;
    }
}