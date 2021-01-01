/**
 * 
 */

/**
 * @author amishra
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int revenues_1[] = {100, 200, 300, 400, 500};
	    int milestones_1[] = {300, 800, 1000, 1400};
	    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
	    for (int indx = 0; indx < output_1.length; indx++)
	    	System.out.println(output_1[indx]);
	}

	// Add any helper functions you may need here

	  static int[] getMilestoneDays(int[] revenues, int[] milestones) {
	    // Write your code here
	    int [] output = new int[milestones.length];
	    int sum = 0;
	    int milestoneIndx = 0;
	    for (int indx = 0; indx < milestones.length; indx++) {
	    	
	    	for (int i = milestoneIndx; i < revenues.length; i++) {
	    		if (sum >= milestones[indx]) {
	    			output[indx] = i + 1;
	    			milestoneIndx = i + 1;
	    		}
	    		else {
	    			sum += revenues[i];
		    		if (sum >= milestones[indx]) {
		    			output[indx] = i + 1;
		    			milestoneIndx = i + 1;
		    			break;
		    		}
	    		}
	    	}
	    	if (0 == output[indx])
	    		output[indx] = -1;
	    }
	    return output;
	  }
}
