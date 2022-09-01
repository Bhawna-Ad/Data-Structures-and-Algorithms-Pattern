package Greedy;

// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// Choose using value per weight
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

import java.util.Arrays;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    class Solution {
        //Function to get the maximum total value in the knapsack.
        double fractionalKnapsack(int W, Item arr[], int n) {
            // Your code here
            Arrays.sort(arr, (item1, item2)->item2.value*item1.weight - item1.value*item2.weight);
            double profit = 0.0;

            for(int i=0; i<n; i++) {
                if(arr[i].weight <= W) {
                    profit += arr[i].value;
                    W = W - arr[i].weight;
                } else {
                    profit += (double)(arr[i].value)/arr[i].weight*W;
                    break;
                }
            }

            return profit;
        }

    }
}
