package QuickNotes.Recursion;


// duplicates in a set are allowed but not duplicate sets and array contains unique elements.
// https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = new ArrayList<>();
        combinations(arr, 0, target, new ArrayList<>(), ans);
        System.out.println(ans);
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
