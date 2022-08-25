package Arrays;

// https://www.interviewbit.com/problems/subarray-with-given-xor/
// Using HashMap look for 2 checks.
// 1. Xor all elements in the array.
// 2. Check if Y is present.
// 3. Check if Xor till here is equal to K.
// 4. Update the element's occurrences in map.
// Time Complexity: O(NlogN)     (logN for unordered map)
// Space Complexity: O(N)

import java.util.HashMap;

public class SubarraysWithGivenXor {
    class Solution {
        public int Solve(int[] nums, int k) {
            HashMap<Integer, Integer>map = new HashMap<>();
            int count = 0;
            int xorr = 0;

            for(int num: nums) {
                xorr = xorr ^ num;

                int y = xorr ^ k;
                if(map.get(y) != null)
                    count = count + map.get(y);

                if(xorr == k)
                    count = count + 1;

                map.put(xorr, map.getOrDefault(xorr, 0) + 1);
            }

            return count;
        }
    }
}

/*
* Working:
*                               |----------xor-----------|
*                               [4, 2, 2, 6, 8, 5, 7, 2, 6, 4]
*                               |------y------| |----k----|
*
*                               y ^ k = xor
*                               y = xor ^ k
*
* count the total occurrences of y and xor as k.
*
* Eg: a = [4, 2, 2, 6, 4]   k = 6
*
* count = 0+0 = 0+1 = 1+2 = 3+0 = 3+1 = 4                                                   |               |
* xor = 0^4 = 4^2 = 6^2 = 4^6 = 2^4 = 6                                         |               |
* y = xor ^ k                                                                   |               |
*   = 4 ^ 6 = 2                                                                 |               |
*   = 6 ^ 6 = 0                                                                 |               |
*   = 4 ^ 6 = 2                                                                 |   (2, 1)      |
*   = 2 ^ 6 = 4                                                                 |   (6, 1+1=2)  |
*   = 6 ^ 6 = 0                                                                 |   (4, 1+1=2)  |
*                                                                               |_______________|
*                                                                                    HashMap
*
* */
