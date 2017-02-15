package array;

import static java.util.Arrays.sort;

public class NoDups	{
  
  private static void removeDups (int[] arr) {
    sort(arr);
    for (int i = 0, j = 1; i < arr.length - 1; i++, j++) {
      if (arr[i] == arr [j]) {
      	arr[i] = -918273645;
      }
    }
    for (int k : arr) {
      if (k != -918273645) {
      	System.out.println(k);
      }
    }
  }

  public static void main (String[] args) {
  	NoDups.removeDups(new int[]{1,1,1,7,1,6});
  }
}