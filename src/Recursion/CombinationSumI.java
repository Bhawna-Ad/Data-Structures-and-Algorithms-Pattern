package Recursion;

// https://leetcode.com/problems/combination-sum/
// Time Complexity: O(2^N)
// Space Complexity: O(N)+O(N)

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>>ans = new ArrayList<>();
            combinations(candidates, 0, target, new ArrayList<>(), ans);
            return ans;
        }

        private static void combinations(int[] arr, int index, int target, List<Integer>list, List<List<Integer>>ans) {
            if(index == arr.length) {
                if(target == 0)
                    ans.add(new ArrayList<>(list));
                return;
            }

            if(target < 0)
                return;

            list.add(arr[index]);
            combinations(arr, index, target-arr[index], list, ans);
            list.remove(list.size()-1);
            combinations(arr, index+1, target, list, ans);
        }

    }
}
