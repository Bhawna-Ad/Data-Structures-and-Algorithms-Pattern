package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
            list.add(intervals[0]);
            for(int i=1; i<intervals.length; i++) {
                if(intervals[i][0] <= list.get(list.size()-1)[1])
                    list.get(list.size()-1)[1] = Math.max(intervals[i][1], list.get(list.size()-1)[1]);
                else
                    list.add(intervals[i]);
            }

            return list.toArray(new int[list.size()][]);
        }
    }
}
