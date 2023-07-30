import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,2};
        int[] ans = optimisedApproach1(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static int[] bruteForce(int[] arr)
    {
        //TC : O(N)
        //SC : O(N)
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < arr.length;i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i]) + 1);
            }
            else
            {
                hm.put(arr[i],1);
            }
        }
        int missing = -1;
        int repeating = -1;
        for(int i = 1;i <= arr.length; i++)
        {
            if(hm.containsKey(i) && hm.get(i) == 2)
            {
                repeating = i;
            }
            else if(!hm.containsKey(i))
            {
                missing = i;
            }
            //little optimisation of reducing iterations
            if(missing != -1 && repeating != -1)
            {
                break;
            }
        }
        return new int[]{repeating,missing};
    }

    public static int[] optimisedApproach1(int[] arr)
    {
        //TC : O(N)
        //SC : O(1)
        //this is a mathematical approach for solving the question
        int n = arr.length;
        int sumArr = 0;
        int sumN = n*(n+1)/2;
        int sumArrSquare = 0;
        int sumNSquare = n*(n+1)*(n+2)/6;
        for(int i = 0; i < n;i++)
        {
            sumArr += arr[i];
            sumArrSquare += (arr[i]*arr[i]);
        }
        int val1 = sumArr - sumN;
        int val2 = (sumArrSquare - sumNSquare)/val1;
        int x = (val1 + val2)/2;
        int y = x - val1;

        return new int[]{x,y};
    }







}