package Recursion;

// https://leetcode.com/problems/subsets-ii/
// Time Complexity: O(2^n)
// Space Complexity: O(N);

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>>ans = new ArrayList<>();
            subsets(0, nums, new ArrayList<>(), ans);
            return ans;
        }

        private void subsets(int index, int[] nums, List<Integer>ds, List<List<Integer>>ans) {
            ans.add(new ArrayList<>(ds));

            for(int i=index; i<nums.length; i++) {
                if(i!=index && nums[i]==nums[i-1])
                    continue;

                ds.add(nums[i]);
                subsets(i+1, nums, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }}
