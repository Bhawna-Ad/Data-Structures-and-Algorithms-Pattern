package DynamicProgramming;

// https://leetcode.com/problems/maximum-product-subarray/

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int res = Integer.MIN_VALUE;
            for(int n: nums)
                res = Math.max(res, n);

            int curMin = 1;
            int curMax = 1;

            for(int n: nums) {
                if(n == 0) {
                    curMin = 1;
                    curMax = 1;
                    continue;
                }

                int temp = curMax*n;
                curMax = Math.max(n, Math.max(curMax*n, curMin*n));
                curMin = Math.min(n, Math.min(temp, curMin*n));
                res = Math.max(res, curMax);
            }

            return res;
        }
    }
}
