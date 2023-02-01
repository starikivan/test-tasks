/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two
characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

package leetcode;

import java.util.Arrays;

public class LC_0205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] sArray = new int[256];
        Arrays.fill(sArray, -1);
        int[] tArray = new int[256];
        Arrays.fill(tArray, -1);
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (sArray[s1] == -1 && tArray[t1] == -1) {
                sArray[s1] = t1;
                tArray[t1] = s1;
            } else if (sArray[s1] != t1 || tArray[t1] != s1) {
                return false;
            }
        }
        return true;
    }
}
