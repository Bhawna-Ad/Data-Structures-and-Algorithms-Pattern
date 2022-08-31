package Arrays;

// For every index find the left and right maximum values
// Find the minimum of left and right
// substract the height from the minimum

public class TrappingRainwater {

    // Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    class BruteSolution {
        public int trap(int[] height) {
            int total_water = 0;

            for(int i=0; i<height.length; i++) {
                int left_max = getLeft(height, i);
                int right_max = getRight(height, i);

                int water_stored = Math.min(left_max, right_max)-height[i];
                total_water += water_stored;
                System.out.println(water_stored);
            }

            return total_water;
        }

        private int getLeft(int[] height, int index) {
            int max = height[index];
            while(index >= 0) {
                max = Math.max(max, height[index--]);
            }
            return max;
        }

        private int getRight(int[] height, int index) {
            int max = height[index];
            while(index < height.length)
                max = Math.max(max, height[index++]);
            return max;
        }
    }


    // Better Using prefixes
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;

            int[] left = new int[n];
            getLeft(left, height);

            int[] right = new int[n];
            getRight(right, height);

            int total_water = 0;

            for(int i=0; i<n; i++) {
                int left_max = left[i];
                int right_max = right[i];

                int water_stored = Math.min(left_max, right_max)-height[i];
                total_water += water_stored;
            }

            return total_water;
        }

        private void getLeft(int[] left, int[] height) {
            left[0] = height[0];
            for(int i=1; i<height.length; i++) {
                left[i] = Math.max(left[i-1], height[i]);
            }
        }

        private void getRight(int[] right, int[] height) {
            int n = height.length;
            right[n-1] = height[n-1];
            for(int i=n-2; i>=0; i--) {
                right[i] = Math.max(right[i+1], height[i]);
            }
        }
    }


    // Optimal Solution
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    class OptimalSolution {
        public int trap(int[] height) {
            int n = height.length;
            int left = 0, right = n-1;
            int leftMax = height[0], rightMax = height[n-1];
            int total_water = 0;

            while(left < right) {
                if(leftMax < rightMax) {
                    left++;
                    leftMax = Math.max(leftMax, height[left]);
                    total_water += leftMax - height[left];
                } else {
                    right--;
                    rightMax = Math.max(rightMax, height[right]);
                    total_water += rightMax - height[right];
                }
            }

            return total_water;
        }
    }
}
