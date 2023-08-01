import javax.print.attribute.standard.PrintQuality;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(mooreVotingAlgorithm(arr));
    }

    public static int bruteForce(int[] arr)
    {
        //this is the brute force approach

        for(int i = 0; i < arr.length; i++)
        {
            int count = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[j] == arr[i])
                {
                    count++;
                }
            }
            if(count > arr.length/2)
            {
                return arr[i];
            }
        }
        return -1;
    }

    public static int betterApproach(int[] arr)
    {
        // we can keep track of the frequency of the elements using either
        // a frequency array or a hashMap
        // here we shall use hashmap
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length;i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i]) + 1);
                if(hm.get(arr[i]) > arr.length/2)
                {
                    return arr[i];
                }
            }
            else
            {
                hm.put(arr[i],1);
            }
        }
        return -1;
    }

    public static int mooreVotingAlgorithm(int[] arr)
    {
        int majority = arr[0];
        int count = 1;

        for(int i = 1; i < arr.length; i++)
        {
            //first we check if the count == 0
            //in case we have a new majority
            if(count == 0)
            {
                majority = arr[i];
                count +=1;
                continue;
            }
            else if(arr[i] == majority)
            {
                count += 1;
            }
            else
            {
                count --;
            }
        }
        int verify = 0;
        //now we verify if the element that we have obtained is the majority element
        for(int i = 0;i < arr.length; i++)
        {
               if(arr[i] == majority)
               {
                   verify+=1;
               }
        }

        if(verify > arr.length/2)
        {
            return majority;
        }
        return -1;
    }

    }