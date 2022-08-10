package Arrays;

// https://leetcode.com/problems/unique-paths/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int N = m + n - 2;
            int r = m - 1;

            long res = 1;
            for(int i=1; i<=r; i++) {
                res = res * (N-r+i)/i;
            }
            return (int)res;
        }
    }
}

/* We can use combinatorics to find the number of paths */