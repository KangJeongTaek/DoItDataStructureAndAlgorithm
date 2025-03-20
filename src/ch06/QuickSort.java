package ch06;

import java.util.Scanner;

public class QuickSort {

    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1]; arr[idx1] = arr[idx2]; arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right){
        int pl = left;
        int pr = right;
        int pivot = arr[(left + right) / 2];

        System.out.printf("a[%d]~a[%d] : {",left,right);
        for(int i = left ; i < right ; i ++){
            System.out.printf("%d , ",arr[i]);
        }
        System.out.printf("%d}\n",arr[right]);
        do{
            while(arr[pl] < pivot) pl++;
            while(arr[pr] > pivot) pr--;
            if(pl < pr){
                swap(arr, pl++, pr--);
            }
        }while(pl < pr);

        if(left < pr) quickSort(arr, left, pr);
        if(pl < right) quickSort(arr, pl, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.println("요솟수 : ");
        int n = sc.nextInt();
        int[]x = new int[n];

        for(int i = 0 ; i < n ; i++){
            System.out.println("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, n - 1); // 배열 x를 퀵 정렬
    }
}
