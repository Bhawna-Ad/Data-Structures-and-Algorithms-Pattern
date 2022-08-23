package Arrays;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
// Using hashmap find the element if present that could pair up with current element to form target.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer>map = new HashMap<>();

            for(int i=0; i<nums.length; i++) {
                int rem = target - nums[i];
                if(map.containsKey(rem)) {
                    if(i == map.get(rem))
                        continue;
                    return new int[] {i, map.get(rem)};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
