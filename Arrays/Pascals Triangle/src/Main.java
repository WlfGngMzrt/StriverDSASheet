import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        pascalTriangle(5);
    }
    public static ArrayList<Integer> rowCoefficients(int n)
    {
         ArrayList<Integer> arr = new ArrayList<>();
         int ans = 1;
         arr.add(1);
         // ex dry run : n = 4
         // i = 1 :  ans = 3/1 = 3
         // i = 2 :  ans = 3 * 2/2 = 3
         // i = 3 :  ans = 3 * 1/3 = 1
         for(int i = 1; i < n;  i++)
         {
             ans *= (n-i);
             ans /= (i);
             arr.add(ans);
         }
         return arr;
    }

    //this function creates the pascal triangle of N rows
    public static ArrayList<ArrayList<Integer>> pascalTriangle(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for(int i = 1; i <= n; i++)
        {
            ans.add(rowCoefficients(i));
        }
        System.out.println(ans);
        return ans;
    }
}