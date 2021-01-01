package heap;
import java.util.*;
// Add any extra import statements you may need here


public class LargestTripleProducts {

  // Add any helper functions you may need here
  void heapify(int[] arr, int indx) {
    int indxOfMax = indx;
    int leftChildIndx = 2 * indx + 1;
    int rightChildIndx = 2 * indx + 2;
    if (leftChildIndx < arr.length && arr[leftChildIndx] > arr[indxOfMax])
      indxOfMax = leftChildIndx;
    if (rightChildIndx < arr.length && arr[rightChildIndx] > arr[indxOfMax])
      indxOfMax = rightChildIndx;
    if (indx != indxOfMax) {
      int tmp = arr[indx];
      arr[indx] = arr[indxOfMax];
      arr[indxOfMax] = tmp;
      
      heapify(arr, indxOfMax);
    }
  }

  int[] findMaxProduct(int[] arr) {
    // Write your code here
    if (arr.length <= 2) {
        for (int indx = 0; indx < arr.length; indx++)
          arr[indx] = -1;
        return arr;
      }
    int [] maxHeap = new int[arr.length];
    int [] outputArr = new int[arr.length];
    for (int indx = 0; indx < arr.length; indx++)
      maxHeap[indx] = Integer.MIN_VALUE;
    for (int indx = 0; indx < arr.length; indx++) {
      maxHeap[indx] = arr[indx];
      if (indx <= 1) {
        outputArr[indx] = -1;
      }
      else {
        heapify(maxHeap, 0);
        int x = maxHeap[0];
        maxHeap[0] = Integer.MIN_VALUE;
        heapify(maxHeap, 0);
        int y = maxHeap[0];
        maxHeap[0] = Integer.MIN_VALUE;
        heapify(maxHeap, 0);
        int z = maxHeap[0];
        outputArr[indx] = x*y*z;
        maxHeap[1] = x;
        maxHeap[2] = y;
        heapify(maxHeap, indx);
      }      
    }
    return outputArr;
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
    int[] arr_1 = {1, 2, 3, 4, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
    int[] output_1 = findMaxProduct(arr_1);
    check(expected_1, output_1);
    
    int[] arr_2 = {2, 4, 7, 1, 5, 3};
    int[] expected_2 = {-1, -1, 56, 56, 140, 140};
    int[] output_2 = findMaxProduct(arr_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new LargestTripleProducts().run();
  }
}