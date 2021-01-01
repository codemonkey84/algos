package graph;
import java.io.*;
import java.util.*;

/**
 * Implementation  of BFS traversal to find the shortest distance from a vertex to
 * the rest in an undirected and equally weighted (or, un-weighted) graph
 *
 * @author amishra
 *
 */
public class BFSShortestReach {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

    	// Initialize a 2D matrix to represent the graph
        int [][] graph = new int[n][n];
        
        /**
         *  Populate the graph as per the edges. Since this is a undirected one,
         *  need to populate the both the original indices (x,y & y,x) at the same time
         */
        for (int i = 0; i < m; i++) {
            int j = edges[i][0] - 1;
            int k = edges[i][1] - 1;
            /**
             * Populating 1 indicating a connectivity since this is a equal
             * weighted graph (could be populated with the distance (6) instead)
             */
            graph[j][k] = 1;
            graph[k][j] = 1;
        } 
        int [] distances = new int[n];
        boolean [] visited = new boolean[n];
        Queue<Integer> list = new LinkedList<>();
        
        for (int indx = 0; indx < n; indx++)
            distances[indx] = -1;
        
        // Mark the first node as visited
        visited[s - 1] = true;
        // Add the first node in the queue
        list.add(s);
        
        /**
         * Repeat the following steps until the queue is empty:
         * 
         * 1. Poll the first node (elem) from the queue
         * 2. Iterate over each other nodes
         * 2. Check if edge exists from the polled node to this iterated node
         * 3. If the above is yes, check if the iterated node is visited already
         * 4. If the above is yes, mark the iterated node as visited
         * 5. Add the iterated node in the list
         * 6. Set the distance of the iterated node by incrementing the
         *    distance of the polled node by unit distance
         */
        while (!list.isEmpty()) {
            int elem = list.remove();
            for (int indx = 0; indx < n; indx++) {
                if (!visited[indx] && graph[elem - 1][indx] == 1) {
                    visited[indx] = true;
                    list.add(indx + 1);
                    if (distances[elem - 1] == -1)
                        distances[indx] = 6;
                    else
                        distances[indx] = distances[elem - 1] + 6;
                }
            }
        }
        int [] output = new int[n - 1];
        if (s == 1)
            System.arraycopy(distances, 1, output, 0, output.length);
        else if (s == n)
            System.arraycopy(distances, 0, output, 0, output.length);
        else {
            System.arraycopy(distances, 0, output, 0, s - 1);
            System.arraycopy(distances, s, output, s - 1, output.length - (s - 1));   
        }
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
