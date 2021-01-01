/**
 * 
 */
package array;


/**
 * @author amishra
 *
 */
public class PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] isPrime = new PrimeNumbers().primeNumbers(20);
		for (int indx = 0; indx < isPrime.length; indx++)
			if (isPrime[indx])
				System.out.print(indx+" ");
	}

	private boolean[] primeNumbers(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int indx = 2; indx < n + 1; indx++)
			isPrime[indx] = true;
		for (int indx = 2; indx * indx <= n; indx++) {
			if (isPrime[indx]) {
				for (int j = indx * indx; j <= n; j += indx) { // n(1/3 + 1/5 + 1/7 + .... + p) = log(log N)
					System.out.println(indx+" "+j);
					isPrime[j] = false;
				}
			}
		}
		return isPrime;

	}
}
