package Arrays;

//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
//rightmost set bit: https://www.youtube.com/watch?v=XcSr6TIMl7w&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=3
//Time Complexity: O(5*N)
//Space Complexity: O(1)

public class RepeatAndMissingNumber {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] repeatedNumber(final int[] A) {
            int[] ans = new int[2];

            int xor = 0;
            for(int a: A) {
                xor = xor ^ a;
            }

            for(int i=1; i<=A.length; i++) {
                xor = xor ^ i;
            }

            int rsb = xor & (-xor);
            int x = 0;
            int y = 0;

            for(int a: A) {
                if((a & rsb) == 0) {
                    x = x ^ a;
                } else {
                    y = y ^ a;
                }
            }

            for(int i=1; i<=A.length; i++) {
                if((i & rsb) == 0) {
                    x = x ^ i;
                } else {
                    y = y ^ i;
                }
            }

            for(int a: A) {
                if(x == a) {
                    ans[0] = x;
                    ans[1] = y;
                } else if(a == y) {
                    ans[0] = y;
                    ans[1] = x;
                }
            }

            return ans;
        }
    }

}

/*
 * Xoring all elements of the array and the elements in the range of (1 to n) will cancel out the other elements and only the repeated and missing number will be left in the variable.
 * We will find out the rightmost set bit and create a mask. (the rightmost bit of one of the elements will be off and on for the other).
 * To create the bitmask we use the formula: (xor & (~xor + 1)) same as (xor & -xor).
 * Eg:
 *                   xor = A 1's and 0's     1       B 0's              (B 0's since we need to find the rightmost set bit)
 *                  ~xor = A 0's and 1's     0       B 1's
 *              ~xor + 1 = A 0's and 1's     1       B 0's
 *      xor & (~xor + 1) = A 0's             1       B 0's
 *
 * once the mask with rightmost set bit is created we can find the elements as x ^ y = xor.
 * xor all the elements from the array that have the bit off with x and others with y using & operator with rsb.
 * xor all the elements from the range (1 to n) in similar fashion.
 * out of x and y whichever is present in the array is the repeating element and the other is missing.
 *  */
