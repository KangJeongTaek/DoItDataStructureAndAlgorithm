package ch06;

public class BubbleSort2 {

    static void bubbleSort(int[] arr,int n){
        for(int i=0;i < n - 1;i++){
            int exchg = 0;
            for(int j =n -1 ; j > i; j-- ){
                if(arr[j] < arr[j-1]) {
                    swap(arr,arr[j],arr[j-1]);
                    exchg++;
                }
            }
            if(exchg == 0) break;
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        BubbleSort.swap(arr, idx1, idx2);
    }
}
