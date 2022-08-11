package QuickNotes.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //Subsets
    //No. of Subsets: 2^n

    //Unique elements in array and no duplicate subsets in solution set.
    // A subset does not maintain relative ordering of elements and is neither a contiguous part of an array.
    // Inclusive and Exclusive technique with a loop
    //https://leetcode.com/problems/subsets/
    //Time Complexity: O(N*2^N)
    //Space Complexity: O(N)

    public void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

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
