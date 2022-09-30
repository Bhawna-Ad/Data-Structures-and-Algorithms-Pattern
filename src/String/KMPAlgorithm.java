package String;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// Knuth-Morris-Pratt(KMP) Algorithm
/*
* The algorithm is used for pattern matching in strings. When a string is given and a pattern is given we need to find out
* whether that pattern exists in the string and find its index.
*
* The key idea is to create all the prefixes and suffixes from the given pattern. Once done, find if any prefix is same as suffix.
*
* Eg:
*    let the pattern be abcdabc
*      prefixes: a, ab, abc, abcd, abcda, abcdab
*      suffixes: c, bc, abc, dabc, cdabc, bcdabc
*
*       from these we can see abc is the common substring.
*
*   Next we generate a pie table or LPS (Longest Prefix same as Suffix)
*   Eg:
*            1 2 3 4 5 6 7 8 9 10
*   pattern: a b c d a b e a b f
*            0 0 0 0 1 2 0 1 2 0
*
* Taking two pointers i and j for String and pattern respectively.
* if there is a match:
*   move i and j by 1
* else
*   move j to the corresponding last matched index.
*   move i to the next position where it started from.
*
*  Time Complexity: O(M+N)          [M is the time taken for creating the pi table and N is the time taken for searching]
*
*  To create the LPS, we will treat each index as a substring from 0 to index
*  and in each substring we will find the suffix that also exists as a prefix and mark that index as the number of elements in lps
*
* */

public class KMPAlgorithm {
    public class Solution {
        public static boolean findPattern(String p, String s) {
            // Write your code here.
            int[] lps = new int[p.length()];

            // generate the lps table.
            int prevLPS = 0;
            int i = 1;
            while(i < p.length()) {
                // if the characters match increase both pointers
                if(p.charAt(i) == p.charAt(prevLPS)) {
                    lps[i] = prevLPS + 1;
                    prevLPS++;
                    i++;
                }

                // if the characters do not match
                else {
                    // there was a prefix of this string that matched the suffix of this string
                    if(prevLPS == 0) {
                        lps[i] = 0;
                        i++;
                    }

                    // set the prevLPS to the value of the previous element.
                    else {
                        prevLPS = lps[prevLPS-1];
                    }

                }
            }


            // search the pattern in string.
            i = 0;        // for s
            int j = 0;    // for p
            while(i < s.length()) {
                // if a match is found
                if(s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                }
                // if they do not match
                else {
                    if(j == 0) {
                        i++;
                    } else {
                        j = lps[j-1];
                    }
                }

                // if the pattern is found in the string
                if(j == p.length())
                    return true;
            }

            return false;
        }
    }
}
