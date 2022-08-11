package QuickNotes.Recursion;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// A subsequence maintain relative ordering of elements but may or may not be a contiguous part of an array.
// Number of subsequences: 2^n
// Inclusive and Exclusive technique
// Time Complexity: O(2^n)
// Space Complexity:
public class Subsequences {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<List<Integer>> ans = new ArrayList<>();
        getSubsequences(arr, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void getSubsequences(int[] arr, int index, List<Integer>list, List<List<Integer>>ans) {
        if(index >= arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        getSubsequences(arr, index+1, list, ans);
        list.remove(list.size()-1);
        getSubsequences(arr, index+1, list, ans);
    }
}

/*
*       Recursion Tree:
*
*                                                                    f(0,[])
*                                                   /                                      \
*                                            f(1,[3])                                     f(1,[])
*                                       /               \                             /             \
*                               f(2,[3,1])               f(2,[3])                f(2,[1])           f(2,[])
*                              /         \              /        \               /      \           /      \
*                         f(3,[3,1,2])  f(3,[3,1])   f(3,[3,2])  f(3,[3])  f(3,[1,2])  f(3,[1])   f(3,[2])  f(3,[])
*
*
* */
