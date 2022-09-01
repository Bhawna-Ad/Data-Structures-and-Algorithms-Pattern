package Greedy;

// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
// Sort the given meetings according to their finishing time.
// Time Complexity: O(N)+O(NlognN)+O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInOneRoom {
    class Solution {
        //Function to find the maximum number of meetings that can
        //be performed in a meeting room.
        public static int maxMeetings(int start[], int end[], int n) {
            // add your code here
            List<Pair> meetings = new ArrayList<>();
            for(int i=0; i<n; i++) {
                meetings.add(new Pair(start[i], end[i]));
            }

            Collections.sort(meetings, (p1, p2)->p1.end-p2.end);

            int res = 1;
            int last_endtime = meetings.get(0).end;
            for(int i=1; i<n; i++) {
                if(meetings.get(i).start > last_endtime) {
                    res++;
                    last_endtime = meetings.get(i).end;
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
