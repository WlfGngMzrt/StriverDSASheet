import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static int[] bruteForce1(int[] arr1, int[] arr2)
    {
        //TC : O(N + M + (N+M)log(N+M))
        //SC : O(N+M)
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n+m];
        for(int i = 0;i < n;i++)
        {
            ans[i] = arr1[i];
        }
        for(int i = n; i < m;i++)
        {
            ans[i] = arr2[i];
        }
        Arrays.sort(ans);
        return ans;
    }
    public static int[] bruteForce2(int[] arr1, int[] arr2)
    {
        //TC : O(N+M)
        //SC : O(N+M)
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        int[] ans = new int[arr1.length + arr2.length];
        while(p1 < arr1.length && p2 < arr2.length)
        {
            if(arr1[p1] < arr2[p2])
            {
                ans[k] = arr1[p1];
                k++;
                p1++;
            }
            else
            {
                ans[k] = arr2[p2];
                k++;
                p2++;
            }
        }
        while(p1 < arr1.length)
        {
            ans[k] = arr1[p1];
            k++;
            p1++;
        }
        while(p2 < arr2.length)
        {
            ans[k] = arr2[p2];
            k++;
            p2++;
        }
        return ans;
    }
    public static void optimalSolution1(int[] arr1, int[] arr2)
    {
        //TC : O(Math.min(N,M) + N*logN + M*logM)
        //SC : O(1)
        int p1 = arr1.length - 1;
        int p2 = 0;
        while(p1 >= 0 && p2 <= arr2.length - 1)
        {
            if(arr1[p1] > arr2[p2])
            {
                int temp = arr1[p1];
                arr1[p1] = arr2[p2];
                arr2[p2] = temp;
                p1--;
                p2++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void optimalSolution2(int[] arr1, int[] arr2)
    {
        //TC : O(N+M)
        //SC : O(1)
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n+m)/2 + (n+m)%2 ;
        while(gap > 0)
        {
            int left = 0;
            int right = left + gap;
            while(right < (n+m))
            {
                if(left < n && right >= n)
                {
                    swap(arr1,arr2,left,right-n);
                }
                else if (left >= n)
                {
                    swap(arr2,arr2,left-n,right-n);
                }
                else
                {
                    swap(arr1,arr1,left,right);
                }
            }
            if(gap == 1)
            {
                break;
            }
            gap = (gap/2) + (gap%2);
        }

    }

    public static void swap(int[] arr1, int[] arr2, int i, int j)
    {
        if(arr1[i] > arr2[j])
        {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}
