package Arrays;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// Using hashmap store the sum at indices.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class LargestSubarrayWith0Sum {
    class Solution{
        int maxLen(int[] arr, int n){
            HashMap<Integer, Integer> map = new HashMap<>();

            int maxx = 0;
            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                sum += arr[i];

                if(sum == 0) {
                    maxx = i+1;
                } else {
                    if(map.containsKey(sum)) {
                        maxx = Math.max(maxx, i-map.get(sum));
                    } else {
                        map.put(sum, i);
                    }
                }
            }
            return maxx;
        }
    }
}
