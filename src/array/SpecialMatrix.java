package array;

public class SpecialMatrix {

	private static boolean isDiagonal(int [][] m) {
		int dim = m.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i == j && m[i][j] == 0) {
					return false;
				} else if (i != j && m[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isUpper(int[][] m) {
		int dim = m.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i < j && m[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isLower(int[][] m) {
		int dim = m.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i > j && m[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] m = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				// Diagonal				
				/*if (i == j) {
					m[i][j] = 1;
				} else {
					m[i][j] = 0;
				}*/

				// Lower
				/*if (i > j) {
					m[i][j] = 0;
				} else {
					m[i][j] = 1;
				}*/

				// Upper
				/*if (i > j) {
					m[i][j] = 1;
				} else {
					m[i][j] = 0;
				}*/

				// None of the above
				if (i == j) {
					m[i][j] = 1;
				} else if (i > j) {
					m[i][j] = 2;
				} else {
					m[i][j] = 1;
				}
			}
		}

		if (isDiagonal(m)) {
			System.out.println("Diagonal");
		}
		if (isUpper(m)) {
			System.out.println("Upper");
		}
		if (isLower(m)) {
			System.out.println("Lower");
		}
	}
}