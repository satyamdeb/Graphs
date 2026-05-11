package com.satyamdeb.islands;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '0'},
                {'1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));

    }


    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(!visited[row][col] && grid[row][col] == '1') {
                    islandCount++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return islandCount;
    }

    private static void bfs(int ro, int co, boolean[][] visited, char[][] grid) {
        visited[ro][co] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;


        while(!q.isEmpty()) {
            Pair poll = q.poll();
            int row = poll.first;
            int col = poll.second;

            for(int delRow = -1; delRow <= 1; delRow++) {
                for(int delCol = -1; delCol <= 1; delCol++) {
                    int newRow = row + delRow;
                    int newCol = col + delCol;

                    if((newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) &&
                            (grid[newRow][newCol] == '1') &&
                            !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }

        }
    }


}
class Pair {
    public int first;
    public int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}