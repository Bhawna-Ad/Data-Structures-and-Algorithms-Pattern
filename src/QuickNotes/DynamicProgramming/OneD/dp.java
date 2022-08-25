package QuickNotes.DynamicProgramming.OneD;

import java.util.Arrays;
import java.util.Stack;

public class dp {
    public static void main(String[] args) {
        //int[] heights = {10, 30, 40, 50, 20};

        System.out.println(minDistance("ros", "horse"));
    }
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[] next = new int[n2+1];

        for(int i=0; i<=n2; i++)
            next[i] = n2-i;

        for(int index1=n1-1; index1>=0; index1--) {
            int[] curr = new int[n2+1];
            curr[n2] = n1 - index1;
            for(int index2=n2-1; index2>=0; index2--) {
                if(word1.charAt(index1) == word2.charAt(index2)) {
                    curr[index2] = next[index2+1];
                    continue;
                }

                int insert = 1 + curr[index2+1];
                int delete = 1 + next[index2];
                int replace = 1 + next[index2+1];

                curr[index2] = Math.min(insert, Math.min(delete, replace));
            }
            next = curr;
        }

        return next[0];
    }
}
