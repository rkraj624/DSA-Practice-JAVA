import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1,5,9,2,8,10,3,4,7,6};
        int n = arr.length;
        int[] brr = new int[n];
        // insertionSort(arr, n);
        // selectionSort(arr, n);
        // bubbleSort(arr, n);
        // mergeSort(arr, brr, 0, n-1);
        quickSort(arr, 0, n - 1);
        System.out.println( "Your Sorted Array is " + Arrays.toString(arr));
    }
    private static void quickSort(int[] arr, int left, int high){
        if(left < high){
            // finding partition Index 
            int partitionIndex = partition(arr, left, high);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int left, int high){
        int idx = left - 1; // idx is actual position of pivot 
        int pivot = arr[high];
        for(int i = left ; i < high ; i++){
            if(arr[i] < pivot){ // swapping element greater than pivot 
                idx++;
                swap(arr, i, idx );
            }
        }
        swap(arr, idx + 1, high); // last swap 
        return idx + 1; // returning the pivot index
    }
    private static void mergeSort(int[] arr, int[] brr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, brr, left, mid);
            mergeSort(arr, brr, mid + 1, right );
            merge(arr, brr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int[] brr, int left, int mid, int right){
        int i = left; // starting index
        int j = mid + 1; // middle index
        int k = left; // walking index
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                brr[k++] = arr[i++];
            }else{
                brr[k++] = arr[j++];
            }
        }
        while(i <= mid){
            brr[k++] = arr[i++];
        }
        while(j <= right){
            brr[k++] = arr[j++];
        }
        //transfering element from auxilary array to original array
        for(int idx = 0; idx <= right; idx++){
            arr[idx] = brr[idx];
        }
    }
    private static void bubbleSort(int[] arr, int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }
    private static void insertionSort(int[] arr, int n){
        //insertionSort
        for(int i = 1 ; i < n ; i++){
            for(int j = i -1; j >= 0; j--){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }
    private static void selectionSort(int[] arr, int n){
        for(int i = 0 ; i < n ; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i)
                swap(arr, i, min);
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
