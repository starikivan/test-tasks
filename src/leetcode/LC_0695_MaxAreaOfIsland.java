/**
695. Max Area of Island
Medium

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/

package leetcode;

public class LC_0695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rowsNumber = grid.length;
        int columnsNumber = grid[0].length;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int row, int column) {
        int rowsNumber = grid.length;
        int columnsNumber = grid[0].length;
        if (row < 0 || column < 0 || row >= rowsNumber || column >= columnsNumber || grid[row][column] == 0) {
            return 0;
        }
        grid[row][column] = 0;
        int area = 1;
        area += area(grid, row + 1, column);
        area += area(grid, row - 1, column);
        area += area(grid, row, column + 1);
        area += area(grid, row, column - 1);
        return area;
    }
}
