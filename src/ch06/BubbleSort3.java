package ch06;

public class BubbleSort3 {

    static void bubbleSort(int[] arr,int n) {
        int k = 0;              // a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            int last = n - 1 ; //마지막으로 요소를 교환한 위치
            for(int j = n ; j >k ; j--){
                if(arr[j] < arr[j-1]){
                    BubbleSort.swap(arr,j,j-1);
                    last = j;
                }
            }
            k = last;
        }
    }
}
