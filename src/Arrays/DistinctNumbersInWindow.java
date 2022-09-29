package Arrays;

// https://www.interviewbit.com/problems/distinct-numbers-in-window/

import java.util.HashMap;

public class DistinctNumbersInWindow {
    public class Solution {
        public int[] dNums(int[] A, int B) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[A.length-B+1];
            int index = 0;

            // left pointer to maintain the size of the window till B.
            int left = 0;
            int count = 1;

            for(int i=0; i<A.length; i++) {
                map.put(A[i], map.getOrDefault(A[i], 0)+1);

                // every time the window length becomes B.
                // remove an element from the left of the window
                // and add another element into the window in the next iteration.
                if(count == B) {
                    ans[index++] = map.size();
                    map.put(A[left], map.get(A[left])-1);

                    if(map.get(A[left]) == 0) {
                        map.remove(A[left]);
                    }

                    left++;
                    count--;
                }

                count++;
            }

            return ans;
        }
    }

}
