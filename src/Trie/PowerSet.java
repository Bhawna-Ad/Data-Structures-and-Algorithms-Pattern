package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/power-set4302/1#
//Time Complexity: O(N*2^N)
//Space Complexity: O(N)
public class PowerSet {

    class IterativeSolution {
        public List<String> AllPossibleStrings(String s) {
            List<String>ans = new ArrayList<>();
            for(int i=0; i<(1<<s.length()); i++) {
                String sub = "";
                for(int j=0; j<s.length(); j++) {
                    if((i & (1 << j)) != 0)
                        sub += s.charAt(j);
                }

                if(sub.length() > 0)
                    ans.add(sub);
            }

            Collections.sort(ans);
            return ans;
        }
    }

    class GFGSolution
    {
        public List<String> AllPossibleStrings(String s)
        {
            // Code here
            List<String>ans = new ArrayList<>();
            substrings(s, 0, "", ans);
            Collections.sort(ans);
            return ans;

        }

        private void substrings(String s, int index, String sub, List<String>ans) {
            if(!sub.equals(""))
                ans.add(sub);

            for(int i=index; i<s.length(); i++) {
                substrings(s, i+1, sub+s.charAt(i), ans);
            }
        }
    }


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
