package Arrays;

// https://leetcode.com/problems/max-consecutive-ones/
// Using Kadane's Algorithm
// Time Complexity: O(N)
// Space Complexity: O(1)

public class MaxConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int sum = 0;
            int max = 0;
            for(int i=0; i<nums.length; i++) {
                sum += nums[i];
                max = Math.max(sum, max);
                if(nums[i] == 0)
                    sum = 0;
            }
            return max;
        }
    }
}
