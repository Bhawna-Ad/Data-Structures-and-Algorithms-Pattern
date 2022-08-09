package QuickNotes.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //Subsets
    //No. of Subsets: 2^n

    //Unique elements in array and no duplicate subsets in solution set.
    //https://leetcode.com/problems/subsets/
    //Time Complexity: O(N*2^N)
    //Space Complexity: O(N)
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

    /* Recursion Tree
    * []       []      []       []       []             [ ]               [ ]                  [      ]
    *         /       /        /        /               / \               / \                  / \    \
    *       [1]     [1]       [1]      [1]            [1]  [2]          [1]  [2]             [1]  [2]  [3]
    *               /        /        /  \            /  \             /  \    \            /  \    \
    *            [1,2]    [1,2]    [1,2] [1,3]      [1,2] [1,3]     [1,2] [1,3] [2,3]   [1,2] [1,3] [2,3]
    *                      /        /               /               /                     /
    *                   [1,2,3]  [1,2,3]         [1,2,3]        [1,2,3]               [1,2,3]
    *
    *
    *
    *
    * */



}
