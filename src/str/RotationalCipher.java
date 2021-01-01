package str;
// Add any extra import statements you may need here


public class RotationalCipher {

  // Add any helper functions you may need here
  

  String rotationalCipher(String input, int rotationFactor) {
    int[] lowerCaseASCII = new int[26];
    int[] upperCaseASCII = new int[26];
 
    char[] output = new char[input.length()];
    for (int indx = 0; indx < lowerCaseASCII.length; indx++)
      lowerCaseASCII[indx] = indx + 97;
    for (int indx = 0; indx < upperCaseASCII.length; indx++)
      upperCaseASCII[indx] = indx + 65;
    
    
    
    for (int indx = 0; indx < input.length(); indx++) {
      int ascii = input.charAt(indx);
      if (ascii >= 48 && ascii <= 57) {
        int rotatedNumber = (ascii - 48 + rotationFactor) % 10;
        output[indx] = (char)(48+rotatedNumber);
      }        
      else if (ascii >= 97 && ascii<= 122) {
        int rotatedIndx = (ascii - 97 + rotationFactor) % 26;
        output[indx] = (char)lowerCaseASCII[rotatedIndx];
      }
      else if (ascii >= 65 && ascii<= 90) {
        int rotatedIndx = (ascii - 65 + rotationFactor) % 26;
        output[indx] = (char)upperCaseASCII[rotatedIndx];
      }
      else
        output[indx] = input.charAt(indx);
    }
    return new String(output);
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected); 
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new RotationalCipher().run();
  }
}