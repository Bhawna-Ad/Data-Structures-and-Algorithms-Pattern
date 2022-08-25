package Arrays;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
// Using HashMap keep updating the index.
// Time Complexity: O(NlogN)
// Space Complexity: O(N)

public class LongestSubstringWithoutRepeat {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();

            int left = 0;
            int right = 0;
            int len = 0;

            while(right < s.length()) {
                if(map.containsKey(s.charAt(right)))
                    left = Math.max(left, map.get(s.charAt(right))+1);

                map.put(s.charAt(right), right);
                len = Math.max(len, right-left+1);
                right++;
            }

            return len;
        }
    }
}
