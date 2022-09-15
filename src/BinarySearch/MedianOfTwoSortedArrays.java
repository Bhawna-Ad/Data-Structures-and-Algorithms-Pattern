package BinarySearch;

// https://www.interviewbit.com/problems/matrix-median/
// Use nested binary search we somehow have to reach the element
// that would be present in the middle if all the elements are arranged in sorted order.
// Time Complexity: O(log(2^32)*N*log(M))
// Space Complexity: O(1)

public class MedianOfTwoSortedArrays {
    public class Solution {
        public int findMedian(int[][] A) {
            int low = 1;
            int high = 1000000000;
            int n = A.length;
            int m = A[0].length;

            // Here we are trying to find the element which will have equal number of elements on both sides
            // when all the elements are kept in a sorted order.
            while(low <= high) {
                int mid = (low + high)/2;
                int count = 0;
                // For every row we have to count the number of elements lesser than the mid element.
                // This is to check the position of the current middle element that whether it is more towards left or right.
                for(int[] a: A) {
                    count += getSmallerElements(a, mid);
                }

                // If the number of elements lesser than the current element (count) are
                // lesser than the half of the total number of elements in the matrix
                // that would mean we are in the left portion and we need to reduce our search space towards right.
                if(count <= (n*m)/2) {
                    low = mid + 1;
                }
                // Otherwise we will need to reduce it towards left in order to reach the middle.
                else {
                    high = mid-1;
                }
            }

            return low;
        }

        private int getSmallerElements(int[] row, int element) {
            int low = 0;
            int high = row.length-1;
            while(low <= high) {
                int mid = (low + high)/2;
                if(row[mid] <= element) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }

            return low;
        }
    }
}
