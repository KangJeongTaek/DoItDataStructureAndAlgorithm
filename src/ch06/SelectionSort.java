package ch06;

public class SelectionSort {

    static void selectionSort(int[] arr, int n) {
        for(int i = 0; i < n - 1; i++) {
            int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 저장
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
                BubbleSort.swap(arr, i, min);
            }
        }
    }
}
