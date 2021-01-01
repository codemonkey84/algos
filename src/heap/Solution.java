package heap;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SnakesAndLadders. */
        int[] arr = new int[]{1,3,2,5,10,11,4};
//        insert(arr, 1);
//        System.out.println();
        delete(arr);
    }
    
    private static void insert(int[] arr, int elem) {
        int[] output = new int[arr.length + 1];
        System.arraycopy(arr,0,output,0,arr.length);
        output[arr.length] = elem;
        upHeapify(output, arr.length);
        
        for (int indx = 0; indx < output.length; indx++) {
            System.out.print(output[indx]);
            System.out.print(",");
        }
    }
    
    private static void delete(int[] arr) {
        arr[0] = arr[arr.length - 1];
        downHeapify(arr, 0);
        
        for (int indx = 0; indx < arr.length - 1; indx++) {
            System.out.print(arr[indx]);
            System.out.print(",");
        }
    }
    
    private static void upHeapify(int[] arr, int indxOfMin) {
        if (indxOfMin > 0) {
            int parentIndx = indxOfMin % 2 == 0 ? (indxOfMin - 2) / 2 : (indxOfMin - 1) / 2;
            if (arr[indxOfMin] < arr[parentIndx]) {
                int tmp = arr[indxOfMin];
                arr[indxOfMin] = arr[parentIndx];
                arr[parentIndx] = tmp;
                
                upHeapify(arr, parentIndx);
            }    
        }
    }
    
    private static void downHeapify(int [] arr, int indx) {
        int indxOfMin = indx;
        int leftChildIndx = 2 * indx + 1;
        int rightChildIndx = 2 * indx + 2;
        
        if (leftChildIndx < arr.length && arr[leftChildIndx] < arr[indxOfMin])
            indxOfMin = leftChildIndx;
        if (rightChildIndx < arr.length && arr[rightChildIndx] < arr[indxOfMin])
            indxOfMin = rightChildIndx;
        if (indx != indxOfMin) {
            int tmp = arr[indxOfMin];
            arr[indxOfMin] = arr[indx];
            arr[indx] = tmp;
            
            downHeapify(arr, indxOfMin);
        }
    }
}
