package graph;

import java.util.*;
import java.io.*;

/**
 * Implement BFS traversal to count the largest contiguous region of 1
 * (can be tweaked to find out all the regions of 1)
 *
 * @author amishra
 *
 */
public class LargestRegion
{
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Queue<Cell> queue = new LinkedList<>();
        int largestRegion = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (1 == grid[i][j] && !visited[i][j]) {
                    queue.add(new Cell(i, j));
                    visited[i][j] = true;
                    int region = 1;
                    while (!queue.isEmpty()) {
            
                        
                        Cell cell = queue.poll();
                        
                        if (cell.x - 1 >= 0 && !visited[cell.x - 1][cell.y] && grid[cell.x - 1][cell.y] == 1) {
                            visited[cell.x - 1][cell.y] = true;
                            region++;
                            queue.add(new Cell(cell.x - 1, cell.y));
                        }
                        
                        if (cell.x + 1 < row && !visited[cell.x + 1][cell.y] && grid[cell.x + 1][cell.y] == 1) {
                            visited[cell.x + 1][cell.y] = true;
                            region++;
                            queue.add(new Cell(cell.x + 1, cell.y));
                        }
                        
                        if (cell.y + 1 < col && !visited[cell.x][cell.y + 1] && grid[cell.x][cell.y + 1] == 1) {
                            visited[cell.x][cell.y + 1] = true;
                            region++;
                            queue.add(new Cell(cell.x, cell.y + 1));
                        }
                        
                        if (cell.y - 1 >= 0 && !visited[cell.x][cell.y - 1] && grid[cell.x][cell.y - 1] == 1) {
                            visited[cell.x][cell.y - 1] = true;
                            region++;
                            queue.add(new Cell(cell.x, cell.y - 1));
                        }
                        
                        if (cell.x - 1 >= 0 && cell.y - 1 >= 0  && !visited[cell.x - 1][cell.y - 1] && grid[cell.x - 1][cell.y - 1] == 1) {
                            visited[cell.x - 1][cell.y - 1] = true;
                            region++;
                            queue.add(new Cell(cell.x - 1, cell.y - 1));
                        }
                        
                        if (cell.x + 1 < row && cell.y + 1 < col && !visited[cell.x + 1][cell.y + 1] && grid[cell.x + 1][cell.y + 1] == 1) {
                            visited[cell.x + 1][cell.y + 1] = true;
                            region++;
                            queue.add(new Cell(cell.x + 1, cell.y + 1));
                            if (cell.x + 1 == row - 1 && cell.y + 1 == col - 1)
                                return region > largestRegion ? region : largestRegion;
                        }
                        
                        if (cell.x - 1 >= 0 && cell.y + 1 < col && !visited[cell.x - 1][cell.y + 1] && grid[cell.x - 1][cell.y + 1] == 1) {
                            visited[cell.x - 1][cell.y + 1] = true;
                            region++;
                            queue.add(new Cell(cell.x - 1, cell.y + 1));
                        }
                        
                        if (cell.x + 1 < row && cell.y - 1 >= 0 && !visited[cell.x + 1][cell.y - 1] && grid[cell.x + 1][cell.y - 1] == 1) {
                            visited[cell.x + 1][cell.y - 1] = true;
                            region++;
                            queue.add(new Cell(cell.x + 1, cell.y - 1));
                        }
                    }
                    if (region > largestRegion)
                            largestRegion = region;
                }
            }
        }
        
        
        return largestRegion;
    }
    
    static class Cell {
        
        int x;
        int y;
        
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            LargestRegion obj = new LargestRegion();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
