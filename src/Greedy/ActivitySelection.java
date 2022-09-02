package Greedy;

// https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1
// Time Complexity: O(NlogN)+O(N)+O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    class Solution {
        //Function to find the maximum number of activities that can
        //be performed by a single person.
        public static int activitySelection(int start[], int end[], int n)
        {
            // add your code here
            List<Pair> acts = new ArrayList<>();
            for(int i=0; i<n; i++) {
                acts.add(new Pair(start[i], end[i]));
            }

            Collections.sort(acts, (p1, p2)->p1.end-p2.end);
            int res = 1;
            int last = acts.get(0).end;
            for(int i=1; i<n; i++) {
                if(acts.get(i).start > last) {
                    res++;
                    last = acts.get(i).end;
                }
            }

            return res;
        }

        private static class Pair {
            int start;
            int end;
            Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }
}
