package Greedy;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
// Sort both the arrays
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

public class MinimumPlatforms {
    class Solution {
        //Function to find the minimum number of platforms required at the
        //railway station such that no train waits.
        static int findPlatform(int arr[], int dep[], int n) {
            // add your code here
            Arrays.sort(arr);
            Arrays.sort(dep);

            int platforms=1, max = 1;
            int i=1, j=0;

            while(i<n && j<n) {
                if(arr[i] <= dep[j]) {
                    platforms++;
                    i++;
                } else {
                    platforms--;
                    j++;
                }

                max = Math.max(platforms, max);
            }

            return max;
        }

    }
}
