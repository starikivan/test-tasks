/**
 2563. Count the Number of Fair Pairs
 Medium

 Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

 A pair (i, j) is fair if:

 0 <= i < j < n, and
 lower <= nums[i] + nums[j] <= upper


 Example 1:

 Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 Output: 6
 Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 Example 2:

 Input: nums = [1,7,9,2,5], lower = 11, upper = 11
 Output: 1
 Explanation: There is a single fair pair: (2,3).


 Constraints:

 1 <= nums.length <= 105
 nums.length == n
 -109 <= nums[i] <= 109
 -109 <= lower <= upper <= 109
 */

package leetcode;

import java.util.Arrays;

public class LC_2563_CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        LC_2563_CountTheNumberOfFairPairs test = new LC_2563_CountTheNumberOfFairPairs();
        System.out.println(test.countFairPairs(new int[] {0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(test.countFairPairs(new int[] {1,7,9,2,5}, 11, 11));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    long countLess(int[] arr, int maxValue) {
        long result = 0;
        for (int i = 0, j = arr.length - 1; i < j; i++) {
            while(i < j && arr[i] + arr[j] > maxValue)
                j--;
            result += j - i;
        }
        return result;
    }
}
