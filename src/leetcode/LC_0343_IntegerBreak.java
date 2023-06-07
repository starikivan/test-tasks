/**
343. Integer Break
Medium

Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those
integers.

Return the maximum product you can get.



Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.


Constraints:

2 <= n <= 58
*/

package leetcode;

public class LC_0343_IntegerBreak {
    public int integerBreak(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 0;
        cache[2] = 1;
        for(int num = 3; num <= n; num++){
            for(int i = 1; i < num; i++){
                int currentMaxProduct = Math.max(cache[num - i], num - i);
                cache[num] = Math.max(cache[num], currentMaxProduct * i);
            }
        }
        return cache[n];
    }
}
