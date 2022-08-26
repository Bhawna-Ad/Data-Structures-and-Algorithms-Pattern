package DynamicProgramming;

// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

public class EggDropping {

    // Recursion
    class RecursionSolution {
        //Function to find minimum number of attempts needed in
        //order to find the critical floor.
        static int eggDrop(int n, int k)
        {
            // Your code here
            return fn(n, k);
        }

        static int fn(int e, int f){
            if(e==1 || f==0 || f==1)return f;
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=f;i++){
                int t = 1 + Math.max(fn(e-1,i-1),fn(e,f-i));
                ans = Math.min(ans,t);
            }
            return ans;
        }
    }

    // Memoization
    class MemoizationSolution {
        //Function to find minimum number of attempts needed in
        //order to find the critical floor.
        static int eggDrop(int n, int k)
        {
            // Your code here
            Integer[][] dp = new Integer[205][205];
            return fn(n, k, dp);
        }

        static int fn(int e, int f, Integer[][] dp){
            if(e==1 || f==0 || f==1)return f;
            if(dp[e][f]!=null)return dp[e][f];
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=f;i++){
                int t = 1 + Math.max(fn(e-1,i-1, dp),fn(e,f-i, dp));
                ans = Math.min(ans,t);
            }
            return dp[e][f]=ans;
        }
    }
}
