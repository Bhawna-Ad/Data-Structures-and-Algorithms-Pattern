package BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Search an element in a rotated sorted array
// Time Complexity : O(logn)
// Space Complexity: O(1)

public class FindPivot {
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length-1;
            while(low <= high) {
                int mid = (low + high)/2;
                if(nums[mid] == target)
                    return mid;

                //if left half is sorted
                if(nums[low] <= nums[mid]) {
                    //if the target lies in the low to mid range
                    if(nums[low]<=target && target<=nums[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

                //if right half is sorted
                else {
                    //if the target lise in the mid to high range
                    if(nums[mid]<=target && target<=nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }

            return -1;
        }
    }
}
