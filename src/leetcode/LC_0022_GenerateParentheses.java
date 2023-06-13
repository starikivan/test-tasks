/**
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8
*/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addParenthese(result,"", 0, 0, n);
        return result;
    }

    private void addParenthese(List<String> result, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (open < max) {
            addParenthese(result, str + "(", open + 1, close, max);
        }
        if (close < open) {
            addParenthese(result, str + ")", open, close + 1, max);
        }
    }
}
