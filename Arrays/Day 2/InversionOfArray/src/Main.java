import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{5,4,3,2,1};
        System.out.println(bruteForce(arr1) + " " + bruteForce(arr2));
        System.out.println(betterApproach(arr1) + " " + betterApproach(arr2));
    }
    public static int bruteForce(int[] arr)
    {
        // we have to find the pairs such that the
        // i < j and A[i] > A[j]
        int count = 0;
        for(int i = 0 ;i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[j] < arr[i])
                {
                    count++;
                }
            }
        }

        return count;
    }
    public static int betterApproach(int[] arr)
    {
        // we use the help of the merge sort
        // with some additional one line of statement
        // and modification with the return type

        return mergeSort(arr,0,arr.length -1);
    }
    public static int merge(int[] arr, int low, int mid, int high)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;
        int count = 0;
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                temp.add(arr[right]);
                count += mid - left + 1;
                right++;
            }
        }
        while(left <= mid)
        {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high)
        {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low ; i <=high; i++)
        {
            arr[i] = temp.get(i-low);
        }
        return count;
    }

    public static int mergeSort(int[] arr, int low, int high)
    {
        int count = 0;
        if(low >= high)
        {
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(arr,low,mid);
        count += mergeSort(arr,mid + 1,high);
        count += merge(arr,low,mid,high);
        return count;
    }




}