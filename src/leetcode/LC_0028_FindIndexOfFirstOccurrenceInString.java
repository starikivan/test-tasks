/**
28. Find the Index of the First Occurrence in a String
Easy
Given two strings needle and haystack, return the index of the first occurrence of needle in
haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/

package leetcode;

public class LC_0028_FindIndexOfFirstOccurrenceInString {
//    public int strStr(String haystack, String needle) {
//        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
//            if(haystack.charAt(i) == needle.charAt(0)) {
//                boolean found = true;
//                for (int j = 1; j < needle.length(); j ++) {
//                    if (haystack.charAt(i + j) != needle.charAt(j)) {
//                        found = false;
//                        break;
//                    }
//                }
//                if (found) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needleLength) return i;
                if (i + j == haystackLength) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}


