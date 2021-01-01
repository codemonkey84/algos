/**
 * 
 */
package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amishra
 *
 */
public class ColorfulNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numberOfWays(new int[] {1, 2,3,4,3}, 6);
	}

	private static int numberOfWays(int[] arr, int k) {
	    // Write your code here
	    int numberOfWays = 0;
	    if (null == arr || arr.length <= 1)
	            return numberOfWays;
	        Map<Integer, Integer> map = new HashMap<>();
	        int halfPresenceCount = 0;
	        for (int indx = 0; indx < arr.length; indx++) {
	            if (k % 2 == 0 && k / 2 == arr[indx]) {
	              halfPresenceCount++; 
	              continue;
	            }
	            if (map.containsKey(arr[indx]))
	              map.put(arr[indx], map.get(arr[indx]) + 1);
	            else
	              map.put(arr[indx], 1);
	            
	            if (map.containsKey(k - arr[indx]))
	              numberOfWays += map.get(k - arr[indx]);
	        }
	        return numberOfWays + (halfPresenceCount*(halfPresenceCount-1)/2);
	  }
}
