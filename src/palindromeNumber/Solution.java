//9. Palindrome Number
//        Given an integer x, return true if x is palindrome integer.
//
//        An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
//
//
//
//        Example 1:
//
//        Input: x = 121
//        Output: true
//        Example 2:
//
//        Input: x = -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//        Example 3:
//
//        Input: x = 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//        Example 4:
//
//        Input: x = -101
//        Output: false
//
//
//        Constraints:
//
//        -231 <= x <= 231 - 1

package palindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int rest = x;
        while (rest > 0) {
            result = result * 10 + rest % 10;
            rest = rest / 10;
        }
        if (x == result) {
            return true;
        }
        return false;
    }
}
