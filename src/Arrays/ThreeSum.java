package Arrays;

// https://leetcode.com/problems/3sum/
// Time Complexity: O(N^2)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>>ans = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                    int low = i+1;
                    int high = nums.length-1;
                    int target = 0-nums[i];
                    while(low < high) {
                        if(nums[low]+nums[high] > target)
                            high--;
                        else if(nums[low]+nums[high] < target)
                            low++;
                        else {
                            ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                            while(low<high && nums[low]==nums[low+1])
                                low++;
                            while(low<high && nums[high]==nums[high-1])
                                high--;
                            low++;
                            high--;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
