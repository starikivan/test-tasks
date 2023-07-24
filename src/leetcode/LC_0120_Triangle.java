/**
120. Triangle
Medium

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current
row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
2
3 4
6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:

Input: triangle = [[-10]]
Output: -10

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

*/

package leetcode;

import java.util.List;

public class LC_0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowsNumber = triangle.size();
        for (int i = rowsNumber - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < currentRow.size(); j++) {
                int currentElement = currentRow.get(j);
                int minPathSum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + currentElement;
                currentRow.set(j, minPathSum);
            }
        }
        return triangle.get(0).get(0);
    }
}
