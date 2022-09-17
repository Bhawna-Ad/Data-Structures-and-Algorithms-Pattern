package BinarySearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// We will perform binary search on one of the arrays.
// The idea is to create a partition such that
// all the elements to the left of the part in array1 and array2 are lesser than
// all the elements to the right of the part in array1 and array2.
// From this partition if the total number of elements is even then we will return the average of middle two elements
// which are the max from the left portion and the minimum from the right portion,
// but if the total number of elements is odd then we will simply return the middle element
// which is the min element from the right portion.
// Time Complexity: O(logn)
// Space Complexity: O(1)

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            // To handle the cases where first array is empty.
            if(n1 == 0) {
                if(n2%2 == 0) {
                    return (nums2[(n2/2)-1]+nums2[n2/2])/2.0;
                } else
                    return nums2[n2/2];
            }

            // Since we want to perform binary search on the first array considering it to be the one with lesser length.
            if(n1 > n2)
                return findMedianSortedArrays(nums2, nums1);

            int total = (n1 + n2);
            int half = total/2;
            int low = 0;
            int high = n1-1;

            while(true) {
                int part1 = low > high ? -1 : (low + high) / 2;
                int part2 = half - part1 - 2;

                int left1 = part1 < 0 ? Integer.MIN_VALUE : nums1[part1];
                int left2 = part2 < 0 ? Integer.MIN_VALUE : nums2[part2];

                int right1 = part1 >= n1-1 ? Integer.MAX_VALUE : nums1[part1 + 1];
                int right2 = part2 >= n2-1 ? Integer.MAX_VALUE : nums2[part2 + 1];

                // The ideal partition will be where the last element from the left portion of each array is lesser than
                // the first element of the right portion of each array.
                if(left1<=right2 && left2<=right1) {
                    // For an array with even number of elements we sum the two middle elements and divide by 2.
                    if(total%2 == 0)
                        return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                    // For odd we just return the middle element.
                    else
                        return Math.min(right1, right2);
                } else if(left1 > right2)
                    high = part1-1;
                else
                    low = part1+1;
            }
        }
    }

}