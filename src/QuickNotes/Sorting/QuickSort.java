package QuickNotes.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 8, 3, 2, 6};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low >= high)
            return;

        int start = low;
        int end = high;
        int mid = (start+end)/2;
        int pivot = nums[mid];

        while (start <= end) {
            while (nums[mid] < nums[start])
                start++;
            while (nums[mid] > nums[end])
                end--;

            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(nums, low, mid);
        quickSort(nums, mid+1, high);
    }
}
