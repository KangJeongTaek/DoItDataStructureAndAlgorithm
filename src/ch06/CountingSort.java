package ch06;

public class CountingSort {

    //도수 정렬 (0 이상 max 이하의 값을 입력)
    static void countingSort(int[] a, int n, int max){
        int[] f= new int[max+1];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) f[a[i]]++;
        for(int i = 1; i <=max ; i ++) f[i] += f[i-1];
        for(int i = n - 1; i>=0; i --) b[--f[a[i]]] = a[i];
        for(int i= 0; i <n; i ++) a[i] = b[i];
    }
}
