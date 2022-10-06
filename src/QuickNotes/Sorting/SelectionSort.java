package QuickNotes.Sorting;

// Start from the last index and find the largest element from the rest of the array.
// if this element is greater than the element present at the last index then swap.

public class SelectionSort {
    private int[] selection(int[] nums) {
        for(int i=nums.length-1; i>=0; i--) {
            int maxx = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] > nums[maxx]) {
                    maxx = j;
                }
            }

            if(nums[maxx] > nums[i]) {
                int temp = nums[maxx];
                nums[maxx] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}
