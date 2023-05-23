/**
934. Shortest Bridge
Medium

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands
in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.



Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1


Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_0934_ShortestBridge {
    int[][] grid;
    boolean[][] visited;
    Queue<int[]> queue;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int columns = grid[0].length;
        visited = new boolean[rows][columns];
        queue = new ArrayDeque<>();
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                    break;
                }
            }
        }
        return bfs();
    }

    //depth-first search (DFS)
    private void dfs(int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] == 0 ||
                visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        queue.offer(new int[]{row, column});
        dfs(row - 1, column);
        dfs(row, column - 1);
        dfs(row + 1, column);
        dfs(row, column + 1);
    }

    //breadth-first search (BFS)
    private int bfs() {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];
                for (int[] direction : directions) {
                    int newRow = currentRow + direction[0];
                    int newColumn = currentColumn + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns &&
                            !visited[newRow][newColumn]) {
                        if (grid[newRow][newColumn] == 1) {
                            return steps;
                        }
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
