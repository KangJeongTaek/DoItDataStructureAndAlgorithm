package ch06;

public class ShellSort {

    static void shellSort(int[] arr, int n){
        for(int h = n /2; h >0 ; h/=2){
            for (int i = h; i < n ; i++){
                int j;
                int tmp = arr[i];
                for(j = i -h ; j >= 0 && arr[j] > tmp; j -=h){
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }
    }
}
