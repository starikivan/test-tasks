/**
118. Pascal's Triangle
Easy

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
*/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        List<Integer> secondRow = List.of(1, 1);
        result.add(secondRow);
        if (numRows == 2) {
            return result;
        }
        List<Integer> previousRow = secondRow;
        for (int i = 2; i < numRows; i++) {
            List<Integer> currentRow  = new ArrayList<>();
            currentRow.add(1);
            for (int j = 0; j < i - 1; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            currentRow.add(1);
            result.add(currentRow);
            previousRow = currentRow;
        }
        return result;
    }
}
