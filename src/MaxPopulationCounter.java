/**
 * 
 */

/**
 * @author amishra
 *
 */
public class MaxPopulationCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxPopulationYear(new int[] {2000,  2001}, new int[] {2001, 2002}));

	}

	private static int findMaxPopulationYear(int [] birthYears, int [] deathYears) {
		int minBirthYear = Integer.MAX_VALUE, maxBirthYear = Integer.MIN_VALUE;
		
		for (int indx = 0; indx < birthYears.length; indx++) {
			if (birthYears[indx] < minBirthYear)
				minBirthYear = birthYears[indx];
			if (deathYears[indx] > maxBirthYear)
				maxBirthYear = deathYears[indx];
		}
		
		int [] arr = new int[maxBirthYear - minBirthYear + 1];
		for (int indx = 0; indx < birthYears.length; indx++) {
			arr[birthYears[indx] - minBirthYear] += 1;
			if ((deathYears[indx] + 1 - minBirthYear) < arr.length)
				arr[deathYears[indx] + 1 - minBirthYear] -= 1;
		}
		
		for (int indx = 0; indx < arr.length; indx++)
			System.out.println(arr[indx]);
		int maxPopulation = arr[0];
		int maxPopulationYear = 0;
		for (int indx = 1; indx < arr.length; indx++) {
			if (maxPopulation < arr[indx] + maxPopulation) {
				maxPopulation = arr[indx] + maxPopulation;
				maxPopulationYear = indx;
			}
		}
		return birthYears[maxPopulationYear];
	}
}
