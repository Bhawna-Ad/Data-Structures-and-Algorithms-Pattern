package BinarySearch;

// https://www.interviewbit.com/problems/allocate-books/

public class AllocateNumberOfPages {
    public class Solution {
        public int books(int[] A, int B) {
            if (B > A.length) return -1;
            int low = A[0];
            int high = 0;
            int ans = -1;

            // Determining low and high as the minimum and maximum number of pages which can be allocated
            for (int num : A) {
                low = Math.min(low, num);
                high += num;
            }

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (isPossible(A, B, mid)) {
                    ans = mid;
                    high = mid - 1; //Trying to find less pages allocated possibility
                } else {
                    low = mid + 1; // When the barrier is not enough to allocate books
                }
            }
            return ans;
        }

        private boolean isPossible(int[] A, int B, int barrier) {
            int student = 0;
            int total_pages = 0;
            for (int page : A) {
                if (page > barrier) return false;
                if (total_pages + page > barrier) {
                    student++;
                    total_pages = page;
                } else {
                    total_pages += page;
                }
            }
            return student < B;
        }
    }
}
