package Recursion;

// https://leetcode.com/problems/combination-sum-ii/
// Time Complexity: O(NlogN)+O(2^N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            combinations(candidates, target, 0, ans, new ArrayList<>());
            return ans;
        }

        public void combinations(int[] candidates, int target, int index, List<List<Integer>>ans, List<Integer>ds) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }

            if(target < 0)
                return;

            for(int i=index; i<candidates.length; i++) {
                if(i==index || candidates[i]!=candidates[i-1]) {
                    ds.add(candidates[i]);
                    combinations(candidates, target-candidates[i], i+1, ans, ds);
                    ds.remove(ds.size()-1);
                }
            }

        }
    }
}
