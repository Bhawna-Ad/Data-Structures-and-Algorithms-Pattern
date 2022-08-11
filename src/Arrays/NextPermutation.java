package Arrays;

//https://leetcode.com/problems/next-permutation/
//Time Complexity: O(3*N)
//Space Complexity:O(1)

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i >=0 && nums[i]>=nums[i+1])
            i--;

        if(i >= 0) {
            int j = nums.length-1;
            while(nums[j]<=nums[i])
                j--;
            swap(nums, i, j);
        }

        reverse(nums, i+1, nums.length-1);
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
}
