package Trie;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
//Time Complexity: O(N*2^N)
//Space Complexity: O(N)
public class PowerSet {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>>subset = new ArrayList<>();
            findSubsets(nums, 0, new ArrayList<>(), subset);
            return subset;
        }

        private void findSubsets(int[] nums, int index, List<Integer>elements, List<List<Integer>>subset) {
            subset.add(new ArrayList<>(elements));

            for(int i=index; i<nums.length; i++) {
                elements.add(nums[i]);
                findSubsets(nums, i+1, elements, subset);
                elements.remove(elements.size()-1);
            }
        }
    }

    //using bit manipulation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
