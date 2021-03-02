package leetcode;//3. Longest Substring Without Repeating Characters
//        Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//        Example 4:
//
//        Input: s = ""
//        Output: 0
//
//
//        Constraints:
//
//        0 <= s.length <= 5 * 104
//        s consists of English letters, digits, symbols and spaces.

import java.util.HashMap;
import java.util.Map;

public class LC_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        String result = "";
        for (int start = 0, end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            if (visited.containsKey(current)) {
                start = Math.max(visited.get(current)+1, start);
            }
            if (result.length() < end - start + 1) {
                result = s.substring(start, end + 1);
            }
            visited.put(current, end);
        }
        return result.length();
    }
}
