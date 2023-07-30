import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution{
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{1,2},{2,4},{2,5},{5,9},{5,10},{5,7}};
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] - b[0] > 0)
                {
                    return 1;
                }
                else if(a[0] == b[0])
                {
                    if(a[1] > b[1])
                    {
                        return 1;
                    }
                }
                return -1;
            }
        });
    }

    public static ArrayList<ArrayList<Integer>> bruteForce(ArrayList<ArrayList<Integer>> intervals)
    {
        //now simple brute force is to take one interval and check if the interval
        //is overlapping with the other intervals by loop from it interval to
        //(i+1) interval and merging overlapping intervals. If they don't merge just add the
        //current updated interval to it and go for the next iteration.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < intervals.size();i++)
        {
            ArrayList<Integer> curr = intervals.get(i);
            int start = curr.get(0);
            int end = curr.get(1);
            if(ans.size() != 0 && end <= ans.get(ans.size() - 1).get(1))
            {
                continue;
            }
            for(int j = i + 1; j < intervals.size(); j++)
            {
                ArrayList<Integer> next = intervals.get(j);
                int curr_start = next.get(0);
                int curr_end = next.get(1);

                if(end >= curr_start)
                {
                    end = Math.max(end,curr_end);
                }
                else
                {
                    break;
                }
            }
            ArrayList<Integer> merged = new ArrayList<>();
            merged.add(start);
            merged.add(end);
            ans.add(merged);
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> optimalSolution(ArrayList<ArrayList<Integer>> intervals)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i =  0; i < intervals.size(); i++)
        {
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);
            if(ans.isEmpty() || start > ans.get(ans.size() - 1).get(1))
            {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(start);
                arr.add(end);
                ans.add(arr);
                continue;
            }
            else
            {
                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), end));
            }
        }
        return ans;
    }
}