package Recursion;

// https://leetcode.com/problems/permutation-sequence/
// Time Complexity: O(N*N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> numbers = new ArrayList<>();
            int fact = 1;
            k = k-1;

            for(int i=1; i<n; i++) {
                fact = fact * i;
                numbers.add(i);
            }
            numbers.add(n);

            String ans = "";
            while(true) {
                int index = k / fact;
                ans = ans + numbers.get(index);
                numbers.remove(index);

                if(numbers.size() == 0)
                    break;

                k = k % fact;
                fact = fact / numbers.size();
            }

            return ans;
        }
    }
}
