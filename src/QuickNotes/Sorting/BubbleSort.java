package QuickNotes.Sorting;

import java.util.Arrays;

// Start from the front and keep swapping until this element reaches its correct index.

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 8, 3, 2, 6, 9};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void bubble(int[] nums) {
        boolean swapped;

        for(int i=0; i<nums.length; i++) {
            swapped = false;
            for(int j=1; j<nums.length-i; j++) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }
    }
}
