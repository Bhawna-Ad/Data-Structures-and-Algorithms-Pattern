package Arrays;

//https://leetcode.com/problems/majority-element-ii/
//Time Complexity: O(N)
//Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MajorityElementsII {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int count1 = 0;
            int count2 = 0;
            int num1 = nums[0];
            int num2 = nums[0];

            for(int num: nums) {
                if(num == num1)
                    count1++;
                else if(num == num2)
                    count2++;
                else if(count1 == 0) {
                    num1 = num;
                    count1 = 1;
                }
                else if(count2 == 0) {
                    num2 = num;
                    count2 = 1;
                }
                else {
                    count1--;
                    count2--;
                }
            }

            List<Integer> list = new ArrayList<>();
            count1 = 0;
            count2 = 0;
            for(int num: nums) {
                if(num == num1)
                    count1++;
                else if(num == num2)
                    count2++;
            }

            if(count1 > (nums.length/3))
                list.add(num1);
            if(count2 > (nums.length/3))
                list.add(num2);

            return list;
        }
    }
}

/*
* The array will not contain more than two elements with major frequencies. Hence, use Boyer Moore's Voting algorithm
*  to get the two elements.
* */
