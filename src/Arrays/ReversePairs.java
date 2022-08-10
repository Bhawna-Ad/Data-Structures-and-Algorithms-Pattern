package Arrays;

// https://leetcode.com/problems/reverse-pairs/
// Time Complexity: O(NlogN) + O(N) + O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length-1);
        }

        private int mergeSort(int[] nums, int low, int high) {
            if(low >= high)
                return 0;

            int mid = (low + high)/2;

            int inversions = mergeSort(nums, low, mid);
            inversions += mergeSort(nums, mid+1, high);
            inversions += merge(nums, low, mid, high);

            return inversions;
        }

        private int merge(int[] nums, int low, int mid, int high) {
            int count=0;
            int j = mid + 1;
            for(int i=low; i<=mid; i++) {
                while(j<=high && nums[i]>(2*(long)nums[j]))
                    j++;
                count += j-(mid + 1);
            }

            List<Integer> list = new ArrayList<>();
            int left = low;
            int right = mid + 1;
            while(left<=mid && right<=high) {
                if(nums[left] <= nums[right])
                    list.add(nums[left++]);
                else
                    list.add(nums[right++]);
            }

            while(left <= mid)
                list.add(nums[left++]);

            while(right <= high)
                list.add(nums[right++]);

            for(int i=low; i<=high; i++)
                nums[i] = list.get(i-low);

            return count;
        }
    }
}
