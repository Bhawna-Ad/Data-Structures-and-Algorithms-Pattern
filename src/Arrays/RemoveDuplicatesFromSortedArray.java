package Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class RemoveDuplicatesFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            for(int j=1; j<nums.length; j++) {
                if(nums[j] != nums[index]) {
                    index++;
                    nums[index] = nums[j];
                }
            }
            return index+1;
        }
    }
}
