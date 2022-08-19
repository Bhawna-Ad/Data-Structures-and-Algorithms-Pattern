package QuickNotes.Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/

public class KthPermutationSequence {
    // Recursive solution will pass but takes too much time.
    // Not really efficient.
    // Exponential Time Complexity
    class Solution {
        int count = 0;
        String ans = "";
        public String getPermutation(int n, int k) {
            boolean[] vis = new boolean[n];
            count = k;
            StringBuilder s = new StringBuilder();
            for(int i=0; i<n; i++)
                s.append((char) ((i+1) + '0'));
            permutations(s, new StringBuilder(), vis);
            return ans;
        }

        public void permutations(StringBuilder s, StringBuilder temp, boolean[] vis) {
            if(count == 0)
                return;
            if(temp.length() == s.length()) {
                count--;
                if(count == 0)
                    ans = temp.toString();
                return;
            }

            for(int i=0; i<s.length(); i++) {
                if(!vis[i]) {
                    vis[i] = true;
                    temp.append(s.charAt(i));
                    permutations(s, temp, vis);
                    temp.deleteCharAt(temp.length()-1);
                    vis[i] = false;
                }
            }
        }
    }


    // iterative solution
    // Efficient
    // Time Complexity: O(N^2)
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        String ans = "";

        for(int i=1; i<n; i++) {
            fact = fact*i;
            numbers.add(i);
        }

        numbers.add(n);
        k = k-1;
        while(true) {
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);

            if(numbers.size() == 0)
                break;

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;
    }
}
