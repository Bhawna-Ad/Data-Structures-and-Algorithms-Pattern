package QuickNotes.Recursion;
import java.util.*;

// https://leetcode.com/problems/subsets-ii/
// duplicate elements in the array
// Time Complexity: O(2^n)*n

public class SubsetsII {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void subsets(int index, int[] nums, List<Integer>ds, List<List<Integer>>ans) {
        ans.add(new ArrayList<>(ds));

        for(int i=index; i<nums.length; i++) {
            if(i==index || nums[i]!=nums[i-1]) {
                ds.add(nums[i]);
                subsets(i+1, nums, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }
}
