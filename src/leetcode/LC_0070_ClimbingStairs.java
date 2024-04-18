/**
70. Climbing Stairs
Easy

Hint
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
*/

package leetcode;

public class LC_0070_ClimbingStairs {

  public int climbStairs(int n) {
    if (n < 3) {
      return n;
    }
    int prev = 1;
    int curr = 2;
    for (int i = 3; i <= n; i++) {
      int temp = prev;
      prev = curr;
      curr = curr + temp;
    }
    return curr;
  }
}
