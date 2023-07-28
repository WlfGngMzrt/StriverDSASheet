import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,0,1,2,2,1,0,2,1,0,2,1,0,2,2,1,1,0};
        // bruteFore(arr);
        //arr = optimalSolution(arr);
        //dutchNationalFlagAlgorithm(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    public static void bruteFore(int[] arr)
    {
        //  we can do this by performing sorting on the array
        // TC : O(log(n))
        // SC : O(1);
        Arrays.sort(arr);
    }

    public static int[] optimalSolution(int[] arr)
    {
        //TC : O(N)
        //SC : O(T) -> T refers to the number of unique numbers in the array
        //     -> constant which implies O(1)
        int[] freq = new int[3];
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros += 1;
            }
            if (arr[i] == 1) {
                ones += 1;
            }
            if (arr[i] == 2) {
                twos += 1;
            }
        }
        int[] newArr = new int[arr.length];
        for(int i = 0; i < zeros; i++)
        {
            newArr[i] = 0;
        }
        for(int i = zeros; i < zeros+ones; i++)
        {
            newArr[i] = 1;
        }
        for(int i = zeros+ones; i < zeros+ones+twos; i++)
        {
            newArr[i] = 2;
        }
        return newArr;
    }
    public static void dutchNationalFlagAlgorithm(int[] arr)
    {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high)
        {
            if(arr[mid] == 0)
            {
                swap(mid,low,arr);
                mid++;
                low++;
            }
            else if(arr[mid] == 1)
            {
                mid++;
            }
            else
            {
                swap(mid,high,arr);
                high--;
            }
        }
    }

    public static void swap(int a, int b , int[] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}