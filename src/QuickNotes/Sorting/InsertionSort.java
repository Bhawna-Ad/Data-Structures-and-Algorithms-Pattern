package QuickNotes.Sorting;

// Insertion sort, sorts in parts.
// like sort till index 1, then in the next pass sort till index 2, then till index 3 and so on...


public class InsertionSort {
    private void insertionSort(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } else
                    break;
            }
        }
    }
}
