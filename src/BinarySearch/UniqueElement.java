package BinarySearch;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
// There is one element in the array which appears once and rest all elements appear twice. We have to find that element.
// Since the array is sorted and each element appear twice, the first occurence of the element will always be at an even index
// and the second occurrence will be at an odd index.
// We just have to check if the mid is an odd index
// then the even index just before it should be equal to the value at this index and vice-versa.
// We can use binary search since the array is sorted.
// Time Complexity: O(logn)
// Space Complexity: O(1)

public class UniqueElement {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int low = 0;
            int high = nums.length-2;

            while(low <= high) {
                int mid = (low + high)/2;
                // Xor will find the other index (if mid is even it will make it odd and vice-versa)
                if(nums[mid] == nums[mid^1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return nums[low];
        }
    }
}
