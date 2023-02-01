/*
1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or
more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */

package leetcode;

public class LC_1071_GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = minLength; i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    private boolean valid(String str1, String str2, int k) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            int n1 = len1 / k, n2 = len2 / k;
            return str1.equals(multiplyString(base, n1)) && str2.equals(multiplyString(base, n2));
        }
    }
    private String multiplyString(String str, int k) {
        return new String(new char[k]).replace("\0", str);
    }
}
