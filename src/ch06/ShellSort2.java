package ch06;

public class ShellSort2 {

    static void shellSort(int[] arr, int n){
        int h;
        for(h = 1; h < n; h= h*3 +1)
            ;
        for(;h > 0 ; h/=3){
            for(int i = h; i < n ; i ++){
                int j;
                int tmp = arr[i];
                for(j = i - h; j >= 0 && arr[j] > tmp; j -= h){
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }
    }
}
