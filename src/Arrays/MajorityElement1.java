package Arrays;

//https://leetcode.com/problems/majority-element/
//Time Complexity: O(N)
//Space Complexity: O(1)

public class MajorityElement1 {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int element = nums[0];

            for(int num: nums) {
                if(count == 0)
                    element = num;
                if(num == element)
                    count = count + 1;
                else
                    count = count - 1;
            }
            return element;
        }
    }
}

/*
* Main logic here is whenever count becomes 0 it means both elements have equal frequency till that index.
* */
