package QuickNotes.DynamicProgramming.OneD;

import java.util.Arrays;
import java.util.Stack;

public class dp {
    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 50, 20};

        System.out.println(frogJump(5, heights, 3));
    }
    public static int frogJump(int n, int[] heights, int k) {
        Integer[] dp = new Integer[n];
        dp[0] = 0;

        for(int index=1; index<n; index++) {
            int ans = Integer.MAX_VALUE;

            for(int i=1; i<=k; i++) {

                if(index - i >= 0) {
                    int first = Math.abs(heights[index]-heights[index-i]) + dp[index-i];
                    ans = Math.min(ans, first);
                }
            }

            dp[index] =  ans;
        }
        return dp[n-1];
    }
}
