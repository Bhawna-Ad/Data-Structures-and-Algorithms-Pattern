package QuickNotes.Recursion;

import java.util.ArrayList;
import java.util.List;

// Inclusive and Exclusive technique
// To count and find the subsequences that sum up to k.
public class SubsequencesWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int target = 2;
        List<List<Integer>> ans = new ArrayList<>();
        int count = subsequences(arr, 0, target, new ArrayList<>(), ans);
        System.out.println(ans);
        System.out.println(count);
    }

    private static int subsequences(int[] arr, int index, int target, List<Integer>list, List<List<Integer>>ans) {
        if(index == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(list));
                return 1;
            }
            return 0;
        }

        if(target < 0)
            return 0;

        list.add(arr[index]);
        int include = subsequences(arr, index+1, target-arr[index], list, ans);
        list.remove(list.size()-1);
        int exclude = subsequences(arr, index+1, target, list, ans);

        return include+exclude;
    }
}

/*
 *       Recursion Tree:
 *
 *                                                   f(0,[],2)
 *                                    /                                    \
 *                           f(1,[1],1)                                    f(1,[],2)
 *                          /          \                              /                 \
 *                 f(2,[1,2],-1)     f(2,[1],1)                f(2,[2],0)               f(2,[],2)
 *                                   /        \                 /      \                 /      \
 *                            f(3,[1,1],0)  f(3,[1],1)  f(3,[2,1],-1)  f(3,[2],0)   f(3,[1],1)  f(3,[],2)
 *                            ------------                             ----------
 *
 * */