package String;

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
* */

public class KMPAlgorithm {
}
