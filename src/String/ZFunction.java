package String;

/*
* Pattern matching algorithm
* Print the indices of all the occurrences of a pattern in the string.
*
* Algorithm:
* We build a Z-array. The z-array consists of the longest prefix from s[0] to s[n-1] for s[i].
* We concatenate the pattern with the string as pattern + $ + string
*  and if at any point the length of the pattern exists then we have a match.
*
* Time Complexity: O(pattern.length())
* Space Complexity: O(pattern.length())
* */

public class ZFunction {
    public class Solution {
        public static int zAlgorithm(String s, String p, int n, int m) {
            // Write your code here
            int left = 0;
            int right = 0;
            int count = 0;
            String concat = p + "$" + s;
            int clen = concat.length();

            int[] zarr = new int[clen];
            zarr[0] = 0;
            for(int i=0; i<clen; i++) {
                if(i > right) {
                    left = i;
                    right = i;
                    while(right<clen && concat.charAt(right-left) == concat.charAt(right))
                        right++;
                    zarr[i] = right-left;
                    right--;
                    if(zarr[i] == p.length())
                        count++;
                } else {
                    int pos = i - left;
                    if(zarr[pos] < right-i+1) {
                        zarr[i] = zarr[pos];
                        if(zarr[i] == p.length()) {
                            count++;
                        }
                    } else {
                        left = i;
                        while(right<clen && concat.charAt(right-left)==concat.charAt(right))
                            right++;
                        zarr[i] = right - left;
                        right--;

                        if(zarr[i] == p.length())
                            count++;
                    }
                }
            }
            return count;
        }
    }
}
