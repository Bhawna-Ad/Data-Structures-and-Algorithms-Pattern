package Arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/submissions/
// Using set.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int longestStreak = 0;

            for(int num: nums)
                set.add(num);

            for(int num: nums) {
                if(!set.contains(num-1)) {
                    int currNum = num;
                    int currStreak = 1;

                    while(set.contains(currNum+1)) {
                        currNum++;
                        currStreak++;
                    }

                    longestStreak = Math.max(longestStreak, currStreak);
                }
            }

            return longestStreak;
        }
    }
}
