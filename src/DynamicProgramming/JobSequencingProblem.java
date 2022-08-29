package DynamicProgramming;

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
// Time Complexity: O(NlogN) + O(N*M)
// Space Complexity: O(M)

import java.util.Arrays;

public class JobSequencingProblem {
    class Solution {
        //Function to find the maximum profit and the number of jobs done.
        int[] JobScheduling(Job arr[], int n) {
            // Your code here
            Arrays.sort(arr, (a, b)->(b.profit - a.profit));

            int maxx = 0;
            for(Job job: arr) {
                maxx = Math.max(job.deadline, maxx);
            }

            Integer[] res = new Integer[maxx+1];

            int jobs = 0;
            int profit = 0;

            for(int i=0; i<n; i++) {
                for(int j=arr[i].deadline; j>0; j--) {
                    if(res[j] == null) {
                        res[j] = i;
                        jobs++;
                        profit = profit+arr[i].profit;
                        break;
                    }
                }
            }

            return new int[] {jobs, profit};
        }
    }
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}

