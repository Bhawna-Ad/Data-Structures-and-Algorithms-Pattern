package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/

public class AllPermutations {
    // Recursive Solution
    class RecursiveSolution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>>list = new ArrayList<>();
            perm(nums, list, new ArrayList<>());
            return list;
        }
        private void perm(int[] nums, List<List<Integer>>list, List<Integer> values) {
            if(values.size() == nums.length) {
                list.add(new ArrayList<>(values));
                return;
            }

            for(int i=0; i<nums.length; i++) {
                if(!values.contains(nums[i])) {
                    values.add(nums[i]);
                    perm(nums, list, values);
                    values.remove(values.size()-1);
                }
            }
        }
    }

    // Solution using swapping
    class SwapSolution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            perm(nums, 0, list);
            return list;
        }

        private void perm(int[] nums, int index, List<List<Integer>> list) {
            if(index == nums.length) {
                List<Integer>ds = new ArrayList<>();
                for(int num: nums)
                    ds.add(num);
                list.add(new ArrayList<>(ds));
                return;
            }

            for(int i=index; i<nums.length; i++) {
                swap(i, index, nums);
                perm(nums, index+1, list);
                swap(i, index, nums);
            }
        }

        private void swap(int first, int second, int[] nums) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }
}
