package QuickNotes.Sorting;

// works when the data is in the range from 1 to n.
// check whether every element is present at the index with the value equal to the element.

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        cycle(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void cycle(int[] nums) {
        int i = 0;
        while (i<nums.length) {
            if(nums[i] != i+1) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else
                i++;
        }
    }
}
