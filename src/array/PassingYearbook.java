package array;
import java.io.*; 
// Add any extra import statements you may need here


public class PassingYearbook {

  // Add any helper functions you may need here
  

  int[] findSignatureCounts(int[] arr) {
    // Write your code here
    int[] output = new int[arr.length];
    for (int indx = 0; indx < arr.length; indx++) {
      int passes = 1;
      int i = indx;
      while (i < arr.length && arr[arr[i]-1] != arr[indx]) {
        passes++;
        i++;
      }
      output[indx] = passes;
    }
    return output;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  
  public void run() {
    int[] arr_1 = {2, 1};
    int[] expected_1 = {2, 2};
    int[] output_1 = findSignatureCounts(arr_1);
    check(expected_1, output_1);
    
    int[] arr_2 = {1, 2};
    int[] expected_2 = {1, 1};
    int[] output_2 = findSignatureCounts(arr_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) throws IOException {
    new PassingYearbook().run();
  }
}