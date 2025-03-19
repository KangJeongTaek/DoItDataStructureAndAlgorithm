package ch06;

public class InsertionSort {

    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
