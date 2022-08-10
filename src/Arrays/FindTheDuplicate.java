package Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/submissions/
//Time Complexity: O(N)
//Space Complexity: O(1)
public class FindTheDuplicate {
    class Solution {
        public int findDuplicate(int[] nums) {
            int fast = nums[0];
            int slow = nums[0];

            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while(fast != slow);

            slow = nums[0];
            while(slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
