package QuickNotes.Recursion;
import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

// https://leetcode.com/problems/permutations/
// Time Complexity: O(2^n)*n

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perm = new ArrayList<>();
        permutations(perm, new ArrayList<>(), nums, 0);
        return perm;
    }

    public static void permutations(List<List<Integer>> perm, List<Integer> elements, int[] nums, int index) {
        if(index == nums.length) {
            perm.add(new ArrayList<>(elements));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!elements.contains(nums[i])) {
                elements.add(nums[i]);
                permutations(perm, elements, nums, index + 1);
                elements.remove(elements.size() - 1);
            }
        }
    }
}
