package graph;

public class ShortestPath {


	public static int[] find(int[][] graph, int src) {
		int size = graph[0].length;

		int [] out = new int[size];
		boolean [] visited = new boolean[size]; // Visited vertices indicator

		for (int i = 0; i < size; i++){
            out[i] = Integer.MAX_VALUE;
        }
		out[src] = 0; // Distance from source to source

		for (int i = 0; i < size - 1; i++) {
			int min = findMin(out, visited);
			System.out.println("min: "+min);
			visited[min] = true;

			for (int j = 0; j < size; j++) {
				/**
				* Update if bertex not visited, have an edge, and length of
				* total path from source to j via min is lesser than current
				* length of path from source to j
				*/
				if (!visited[j] && out[min] != Integer.MAX_VALUE
					&& graph[min][j] != 0 && (out[min] + graph[min][j]) < out[j]) {
						System.out.println("here");
						out[j] = out[min] + graph[min][j];}
			}
		}
		return out;
	}

	// Find index of min
	private static int findMin(int [] arr, boolean [] visited) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= min && !visited[i]) {
				min = arr[i];
				min_index = i;
			}
		}
		return min_index;
	}

	// A utility function to print the constructed distance array
	private static void printSolution(int [] arr, int source) {
	   System.out.println("Vertex   Distance from Source index: "+source);
	   for (int i = 0; i < arr.length; i++) {
	      System.out.println(i+" : "+ arr[i]);
	   }
	}

	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
   		int[][] graph = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 14, 10, 0, 2, 0, 0},
                      {0, 0, 0, 0, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                    };
		int [] out = find(graph, 0);
		printSolution(out, 0);
	}
}