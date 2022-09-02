package Recursion;

// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
// Time Complexity: O(2^n)
// Space Complexity: O(N)

import java.util.ArrayList;

public class SubsetSums {
    class Solution{
        ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
            // code here
            ArrayList<Integer>sums = new ArrayList<>();
            subsets(arr, sums, 0, 0);
            return sums;
        }

        private void subsets(ArrayList<Integer>arr, ArrayList<Integer>sums, int sum, int index) {
            sums.add(sum);

            for(int i=index; i<arr.size(); i++) {
                sum += arr.get(i);
                subsets(arr, sums, sum, i+1);
                sum -= arr.get(i);
            }
        }
    }
}
