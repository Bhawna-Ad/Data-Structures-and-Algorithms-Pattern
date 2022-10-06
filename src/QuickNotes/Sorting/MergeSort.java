package QuickNotes.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 8, 3, 2, 6, 9};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if(low >= high)
            return;

        int mid = (low + high)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int l = mid - low + 1;
        int r = high - mid;

        int[] left = new int[l];
        int[] right = new int[r];

        for(int index=0; index<l; ++index)
            left[index] = nums[low + index];
        for(int index=0; index<r; ++index)
            right[index] = nums[mid + 1 + index];

        int i = 0;
        int j = 0;
        int k = low;
        while (i<l && j<r) {
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < l) {
            nums[k++] = left[i++];
        }

        while (j < r) {
            nums[k++] = right[j++];
        }
    }
}
