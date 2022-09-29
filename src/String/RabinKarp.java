package String;

/*
* Rabin Karp Algorithm
* Pattern/String Matching Algorithm: A pattern and a string is given find out whether the string contains the given pattern or not.
* The key idea over here is we map the alphabets with a code it can be from range 1 to 26. Now we add the codes of the alphabets
* in the pattern which will form our hashcode. Then we will use this hashcode to find in the given string whether a window of size
* pattern.length adds up to form this hashcode. To check the hashcode we will use sliding window technique.
*
* Drawback:
* There is a possibility of collision with other substrings which are having the same hashcode though they are not the patterns.
* These are called Spurious hits.
* So in such a situation the worst case time complexity will be O(M*N) while the average time complexity has to be O(N-M+1),
* where N is the length of the string and M is the length of the pattern.
*
* To Resolve this we will create the hashcode in a different fashion. We will multiply each code with a base,
* this base will depend on the number of alphabets that we are considering to make hashcodes for. So if we have 26 alphabets
* and we are trying to create hashcodes for these values then we will take base as 26.
*
*
* Consider this Example:
* String : "ccaccaaedba"
* pattern: "dba"
*
* Let the codes be:
* a -> 1; b->2; c->3, d->4; e->5, f->6, g->7, h->8, i->9, j->10
*
* so according to the codes the hashcode for the given pattern will be:
*       d         b       a
*     4*10^2 + 2*10^1 + 1*10^0 = 421
*
* now we will check if this hashcode 421 is formed by any of the substrings or not.
*
*  First window:
*         c       c       a
*      3*10^2 + 3*10^1 + 1*10^0 = 331
*
*   Second window:
*       c       a       c
*       [331 - 3*10^2]*10 + 3*10^0 = 313            [using the sliding window technique]
*
*   and so on...
*
* */

import java.util.ArrayList;

public class RabinKarp {
    public static void main(String[] args) {
        System.out.println(stringMatch("M", ""));
    }

    public static ArrayList<Integer> stringMatch(String str, String pat) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        int base = 31;
        int m = pat.length();
        int hashcode = 0;
        int mod = 998244353;
        int power = 1;


        // calculating the power for the first element of the window
        // to be used later when removing element from the window
        for(int i=0; i<m-1; i++)
            power = (power*base)%mod;


        // finding the hashcode for the pattern.
        for(int i=0; i<pat.length(); i++) {
            hashcode = (hashcode*base + pat.charAt(i))%mod;
        }

        // using sliding window technique for rolling hash
        int left = 0;
        int currcode = 0;
        String s = "";
        for(int i=0; i<str.length(); i++) {
            s += str.charAt(i);
            currcode = (currcode*base + str.charAt(i))%mod;
            // when window becomes the size of m
            if(s.length() == m) {
                if(currcode == hashcode && s.equals(pat)) {
                    ans.add(left);
                }

                // removing hashcode of the first element from this window
                // to make space for adding another element in window.
                currcode = (currcode - (str.charAt(left)*power))%mod;
                // removing element from the beginning.
                left++;
                s = s.substring(1);
            }
        }

        return ans;
    }

//    public static ArrayList<Integer> stringMatch(String str, String pat) {
//        // Write your code here.
//        ArrayList<Integer> ans = new ArrayList<>();
//        int[] codes = new int[26];
//        for(int i=1; i<=26; i++)
//            codes[i-1] = i;
//
//        int base = 26;
//        int m = pat.length();
//        int hashcode = 0;
//        for(int i=0; i<pat.length(); i++) {
//            hashcode = hashcode*base + codes[pat.charAt(i)-'A'];
//        }
//
//        int left = 0;
//        int currcode = 0;
//        String s = "";
//        for(int i=0; i<str.length(); i++) {
//            s += str.charAt(i);
//            System.out.println(currcode);
//            currcode = currcode*base + codes[str.charAt(i)-'A'];
//            if(s.length() == m) {
//                if(currcode == hashcode && s.equals(pat)) {
//                    ans.add(left);
//                }
//                currcode = currcode - (codes[str.charAt(left)-'A']*((int)(Math.pow(base, m-1))));
//                left++;
//                s = s.substring(1);
//            }
//        }
//
//        return ans;
//    }
}
