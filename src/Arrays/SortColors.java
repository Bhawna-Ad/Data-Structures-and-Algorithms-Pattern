package Arrays;

//https://leetcode.com/problems/sort-colors/
//Time Complexity: O(N)
//Space Complexity: O(1)
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int start = 0;
            int end = nums.length-1;

            int i=0;
            while(i <= end) {
                if(nums[i] == 0) {
                    swap(nums, i, start);
                    i++;
                    start++;
                } else if(nums[i] == 2) {
                    swap(nums, i, end);
                    end--;
                } else
                    i++;
            }
        }

        private void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }
}
