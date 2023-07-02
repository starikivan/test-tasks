/**
200. Number of Islands
Medium

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

package leetcode;

public class LC_0200_NumberOfIslands {
    private char[][] grid;
    private int rows;
    private int columns;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    validateIsland(i, j);
                }
            }
        }
        return result;
    }

    private void validateIsland(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        validateIsland( i - 1, j);
        validateIsland( i + 1, j);
        validateIsland( i, j - 1);
        validateIsland( i, j + 1);
   }
}
