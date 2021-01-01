package graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implemented Djikstra's Single Source Shortest Path algorithm by finding
 * the vertex having minimum distance from source, and relaxing the same
 * by recalculating the distances of it's adjacent vertices from source and
 * iterating the same process for all the reachable un-relaxed vertices
 *
 * @author amishra
 *
 */
public class DjikstrasShortestPath {

    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {

        // Initialize a 2D matrix to represent the graph
        int [][] graph = new int[n][n];
        
        /**
         *  Populate the graph as per the edges. Since this is a undirected one,
         *  need to populate the both the original indices (x,y & y,x) at the same time
         */
        for (int i = 0; i < edges.length; i++) {
            int j = edges[i][0] - 1;
            int k = edges[i][1] - 1;
            graph[j][k] = edges[i][2];
            graph[k][j] = edges[i][2];
        } 
        int [] distances = new int[n];
        boolean [] relaxed = new boolean[n];
        
        for (int indx = 0; indx < n; indx++)
            distances[indx] = Integer.MAX_VALUE;
        
        distances[s - 1] = 0;     
        
        for (int indx = 0; indx < n; indx++ ) {
        	// Find vertex with minimum distance from source
            int minIndx = findVertexIndxWithMinDist(distances, relaxed);
            relaxed[minIndx] = true;
            for (int i = 0; i < n; i++) {
                if (!relaxed[i] && // If it's not relaxed already
                	// If there is a connecting edge between the vertex being relaxed and the iterated vertex
                    graph[minIndx][i] != 0 &&
                    distances[minIndx] != Integer.MAX_VALUE &&
                    // Updating the distance of the target vertex if lower than the previously calculated distance 
                    distances[minIndx] + graph[minIndx][i] < distances[i])
                    
                        distances[i] = distances[minIndx] + graph[minIndx][i];
            }
        }
        
        for (int indx = 0; indx < n; indx++ )
            if (Integer.MAX_VALUE == distances[indx])
                distances[indx] = -1;

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

    private static int findVertexIndxWithMinDist(int[] distances, boolean[] relaxed) {
        int minIndx = -1;
        int minIndxVertex = Integer.MAX_VALUE;
        for (int indx = 0; indx < distances.length; indx++)
            if (!relaxed[indx] && distances[indx] <= minIndxVertex) {
                minIndxVertex = distances[indx];
                minIndx = indx;
            }
        return minIndx;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, edges, s);

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
