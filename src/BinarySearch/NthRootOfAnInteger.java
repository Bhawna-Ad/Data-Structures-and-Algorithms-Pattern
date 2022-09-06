package BinarySearch;

// Using binary search, check if the middle element multiplies up to form the given number
// the range will be taken as l=1 and h=m
//  Time Complexity: O(N*log(M*10^d))
// Space Complexity: O(1)

public class NthRootOfAnInteger {
    public class Solution {
        public static double findNthRootOfM(int n, int m) {
            // Write your code here.
            double ans = 1.0;
            double low = 1;
            double high = m;
            double eps = 1e-7;

            // eps to ensure the answer is upto 6 decimal places.
            while((high-low) > eps) {
                double mid = (low+high)/2.0;
                if(multiply(mid, n) < m ) {
                    ans = mid;
                    low = mid;
                } else {
                    high = mid;
                }
            }

            return ans;
        }

        private static double multiply(double number, int power) {
            double ans = 1.0;
            for(int i=1; i<=power; i++) {
                ans = ans * number;
            }

            return ans;
        }
    }

}
