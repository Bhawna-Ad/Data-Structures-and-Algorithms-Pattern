package QuickNotes.Recursion;

// https://leetcode.com/problems/combination-sum-ii/
// Array contains duplicate elements and each element can be used once in a set. No duplicate sets allowed.
// Inclusive and Exclusive technique
// Time Complexity: O(2^n)*target

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        combinations(arr, 0, target, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void combinations(int[] arr, int index, int target, List<Integer>list, List<List<Integer>>ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0)
            return;

        for(int i=index; i<arr.length; i++) {
            if(i==index || arr[i]!=arr[i-1]) {
                list.add(arr[i]);
                combinations(arr, i+1, target-arr[i], list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}
