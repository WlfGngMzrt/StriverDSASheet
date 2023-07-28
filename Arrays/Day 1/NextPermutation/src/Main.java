public class Main {
    public static void main(String[] args) {
        int[] ques = new int[]{5,3,6,7,1};
        int[] res = nextPermutation(ques);
        for( int i : res)
        {
            System.out.print(i + " ");
        }
    }
    public static int[] nextPermutation(int[] arr)
    {
        //the objective is to perform operations on the given array such that
        //we re-arrange the elements to form the next permutation of the given
        //array number
        //first we fin the number such that arr[i] > arr[i+1]
        int pivot_idx = Integer.MAX_VALUE;
        for(int i = arr.length - 2; i >= 0; i--)
        {
            if(arr[i+1] > arr[i])
            {
                pivot_idx = i;
                break;
            }
        }
        System.out.println("Pivot Index : " + pivot_idx);
        if(pivot_idx == Integer.MAX_VALUE)
        {
            reverse(0,arr.length - 1, arr);
            return arr;
        }
        //replacing the pivot index with the element just  greater than it
        //to its right

       for(int i = arr.length - 1; i >= pivot_idx; i--)
       {
           if(arr[i] > arr[pivot_idx])
           {
               int temp = arr[i];
               arr[i] = arr[pivot_idx];
               arr[pivot_idx] = temp;
               break;
           }
       }

       reverse(pivot_idx+1,arr.length-1,arr);
       return arr;

    }

    public static void swap (int a, int b , int[] arr)
    {
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void reverse(int s, int e, int[] arr)
    {
        while(s < e)
        {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}