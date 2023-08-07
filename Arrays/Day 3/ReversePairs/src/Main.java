import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,4};
        System.out.println(bruteForce(arr));
    }


    public static int bruteForce(int[] arr)
    {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] > 2 * arr[j])
                {
                    count += 1;
                }
            }
        }
        return count;
    }


    public static int optimisedApproach(int[] arr)
    {
        // note our objective is to
        //1. i < j;
        //2. arr[i] > arr[j];

        //approach : mergeSort

    }

    public static int mergeSort(int low, int high, int[] arr)
    {
        int count = 0;
        if(low >= high)
        {
            return count;
        }
        int middle = (low+high)/2;
        count += mergeSort(low,middle,arr);
        count += mergeSort(middle+1,high,arr);
        count += countPairs(arr,low,mid,high);
        merge(low,middle,high,arr);
    }
    public static void merge(int low, int middle, int high, int[] arr)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = middle + 1;
        while(left <= middle && right <= high)
        {
            if(arr[left] < arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= middle)
        {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high)
        {
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; i++)
        {
            arr[i] = temp.get(i-low);
        }
    }

    }

}