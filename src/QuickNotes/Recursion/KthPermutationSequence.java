package QuickNotes.Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/

public class KthPermutationSequence {
    // Recursive solution will pass but takes too much time.
    // Not really efficient.
    // Exponential Time Complexity: O(N!*N)

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
            int index = k/fact;
            ans = ans + numbers.get(index);
            numbers.remove(index);

            if(numbers.size() == 0)
                break;

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;
    }

    /*
    * Explanation:
    *
    * n=4, k=17 (for 0-based indexing find 16th permutation)
    *
    * 1st pass:
    * index = 16 / 6 = 2
    * k = 16 % 6 = 4
    * 0 -> 1 + (2, 3, 4)    ]3!=6   (0 - 5)
    * 1 -> 2 + (1, 3, 4)    ]6      (6 - 11)
    * 2 -> 3 + (1, 2, 4)    ]6      (12 - 17)       <=== index
    * 3 -> 4 + (1, 2, 3)    ]6      (18 - 23)
    *
    *
    * 2nd pass:
    * index = 4 / 2 = 2
    * k = 4 % 2 = 0
    * 3  0 -> 1 + (2, 4)    ]2!=2   (0 - 1)
    *    1 -> 2 + (1, 4)    ]2      (2 - 3)
    *    2 -> 4 + (1, 2)    ]2      (4 - 5)         <=== index
    *
    *
    * 3rd pass:
    * index = 0 / 1 = 0
    * k = 0 % 1 = 0
    * 3  4  0 -> 1 + (2)    ]1!=1   (0)             <=== index
    *       1 -> 2 + (1)    ]1      (1)
    *
    *
    * Final Answer : 3  4   1   2
    *
    * */
}
