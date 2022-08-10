package Arrays;

// https://leetcode.com/problems/powx-n/

public class Power {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    class Solution {
        public double myPow(double x, int n) {
            if(n == 1)
                return x;

            long neg = n < 0 ? -1 : 1;

            double ans = findPow(x, (long)(n*neg));

            return neg < 0 ? (double)(1/ans) : ans;
        }

        private double findPow(double x, long n) {
            if(n == 0)
                return 1;

            if(n%2 == 0)
                return findPow(x*x, n/2);   //for even powers

            return x*findPow(x, n-1);       //for odd powers
        }
    }
    /*
     * for the odd powers the multiplication will be done as the recursion goes back. hence we will have the final ans as 6561
     *  and two threes of the odd powers will be multiplied while going back and completing the remaining recursion steps.
     * for example let x = 3 and pow = 10 the recursion calls will go as:
     *
     *											f(3, 10)
     *											f(9, 5)          //coming from an even power (10/2)
     *									      3*f(9, 4)          //coming from odd power (5-1)
     *											f(81, 2)
     *											f(6561, 1)
     *									      3*f(6561, 0)
     *
     *
     * Recursion tree will be:
     *		                                  10
     *									    /    \
     *									   5      5
     *									   |      |
     *									   4      4
     *								      / \	 / \
     *					                 2   2  2   2
     *
     * */

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    class IterativeSolution {
        public double myPow(double x, int n) {
            if(n == 1)
                return x;
            if(n == 0)
                return 1;

            double ans = 1;
            long neg = n<0 ? -1:1;
            long power = (long)(n*neg);

            while(power > 0) {
                if(power%2 == 0) {
                    x = x * x;
                    power = power / 2;
                } else {
                    ans = ans * x;
                    power = power-1;
                }
            }

            return neg<0 ? (double)(1/ans) : ans;
        }
    }
}


