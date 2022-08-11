package QuickNotes.Recursion;

import java.util.*;

// https://leetcode.com/problems/permutations-ii/solution/
// duplicates elements present in the array and answer should not contain duplicate sets.

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        permutations(set, new ArrayList<>(), nums, vis);
        return getList(set);
    }

    public static void permutations(Set<List<Integer>> set, List<Integer> elements, int[] nums, boolean[] vis) {
        if(elements.size() == nums.length) {
            set.add(new ArrayList<>(elements));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                elements.add(nums[i]);
                permutations(set, elements, nums, vis);
                elements.remove(elements.size()-1);
                vis[i] = false;
            }
        }
    }

    public static List<List<Integer>> getList(Set<List<Integer>> set) {
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> val: set) {
            list.add(val);
        }
        return list;
    }
}
