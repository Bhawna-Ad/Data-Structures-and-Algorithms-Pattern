package Arrays;

// https://www.codingninjas.com/codestudio/problems/count-inversions_615
// Time Complexity: O(NlogN)
// Space Complexity: O(N)

public class CountInversions {
    public class Solution {
        public static long getInversions(long[] arr, int n) {
            // Write your code here.
            return mergeSort(arr, new long[n], 0, n-1);
        }

        private static long mergeSort(long[] arr, long[] temp, int left, int right) {
            long inv_count = 0;
            if(left < right) {
                int mid = (left + right)/2;
                inv_count += mergeSort(arr, temp, left, mid);
                inv_count += mergeSort(arr, temp, mid+1, right);
                inv_count += merge(arr, temp, left, right, mid+1);
            }
            return inv_count;
        }

        private static long merge(long[] arr, long[] temp, int left, int right, int mid) {
            long inv_count = 0;
            int i = left;
            int j = mid;
            int k = left;

            while(i<=mid-1 && j<=right) {
                if(arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                    inv_count += mid - i;
                }
            }

            while(i <= mid-1) {
                temp[k++] = arr[i++];
            }

            while(j <= right) {
                temp[k++] = arr[j++];
            }

            for(i=left; i<=right; i++) {
                arr[i] = temp[i];
            }

            return inv_count;
        }
    }
}

//count for the elements which have a greater value in the left array than the elements in right array since they are the ones to be swapped.
