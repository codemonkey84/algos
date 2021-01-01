package graph;
import java.io.*;
import java.util.*;

/**
 * Implemented BFS traversal to find out the shortest path to a destination
 * for a directed and weighted graph
 *
 * @author amishra
 *
 */
public class SnakesAndLadders {

    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {

        // Initialise an array having same dimension as the number of cells
        int[] destinations = new int[100];
        
        // For all the ladders and snakes, map the source as index and destination
        // as value
        for (int indx = 0; indx < ladders.length; indx++)
            destinations[ladders[indx][0] - 1] = ladders[indx][1] - 1;
        for (int indx = 0; indx < snakes.length; indx++)
            destinations[snakes[indx][0] - 1] = snakes[indx][1] - 1;
            
        boolean[] visited = new boolean[100];
        Queue<Cell> queue = new LinkedList<>();
        
        // Starting the game
        Cell firstCell = new Cell(0, 0);
        visited[0] = true;
        queue.add(firstCell);
        Cell currentCell = firstCell;
        
        // Performing BFS to calculate the min number of dice thrown
        while (!queue.isEmpty()) {
            currentCell = queue.poll();
            // Break out when destination is reached
            if (100 == currentCell.num + 1)
                break;
                
            // Visit all the 6 neighbors for every cell
            for (int indx = currentCell.num + 1; indx <= currentCell.num + 6 && indx < 100; indx++ ) {
                if (!visited[indx]) {
                    int nextCellIndx = 0;
                    visited[indx] = true;
                    // If the next cell is either a ladder or snake, visit the destination cell of the next cell instead
                    if (destinations[indx] == 0)
                        nextCellIndx = indx;
                    else
                        nextCellIndx = destinations[indx];
                    Cell cell = new Cell(nextCellIndx, currentCell.dist + 1);
                    queue.add(cell);
                }
            }
        }
        return 100 == currentCell.num + 1? currentCell.dist : -1;
    }
    
    static class Cell {
        
        int num;
        int dist;// number of dice throws to reach from source
        
        Cell (int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
                    snakes[i][j] = snakesItem;
                }
            }

            int result = quickestWayUp(ladders, snakes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
