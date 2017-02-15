package array;

public class OrderedArraysMerger {

  public static void main (String [] args) {
  	OrderedArraysMerger.merge(new int[]{1,4,7}, new int[]{2,3,9});
  }

  private static void merge(int[] arr1, int[] arr2) {
  	int i = 0, j = 0, k = 0;
  	int destIndex = arr1.length + arr2.length;
  	int[] arr = new int[destIndex];
  	while (i < arr1.length && j < arr2.length) {
  	  if (arr1[i] < arr2[j]) {
  	  	arr[k] = arr1[i];
  	  	++k;
  	  	++i;
  	  } else if (arr1[i] > arr2[j]) {
  	  	arr[k] = arr2[j];
  	  	++k;
  	  	++j;
  	  } else {
  	  	arr[k] = arr1[i];
  	  	++k;
  	  	++i;
  	  	arr[k] = arr2[j];
  	  	++k;
  	  	++j;
  	  }
  	}
  	while (k < destIndex && i < arr1.length) {
  	  arr[k] = arr1[i];
  	  ++k;
  	  ++i;
  	}
  	while (k < destIndex && j < arr2.length) {
  	  arr[k] = arr2[j];
  	  ++k;
  	  ++j;
  	}
  	for (int l : arr) {
  	  System.out.println(l);
  	}
  }
}