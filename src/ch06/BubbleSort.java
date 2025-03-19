package ch06;

import java.util.Scanner;

public class BubbleSort {
    //두 인덱스의 값 교환
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // 버블 정렬
    static void bubbleSort(int[] arr, int n){
        int swapCount = 0;
        int comparision = 0;
        for(int i=0; i<n-1; i++){
            System.out.println("패스 " + (i + 1)  + ": ");
            for(int j = n - 1; j>i; j--){
                for(int k = 0; k< n; k++){
                    System.out.printf("%2d", arr[k]);
                    if(k == j -1){
                        if(arr[j] < arr[j - 1]) System.out.print(" +");
                        else System.out.print(" -");
                    }
                }
                System.out.println();
                if(arr[j] < arr[j-1]) {
                    swapCount++;
                    swap(arr, j, j-1);
                }
                comparision++;
            }
        }
        System.out.printf("비교를 %d회 했습니다.\n",comparision);
        System.out.printf("교환을 %d회 했습니다.", swapCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("버블 정렬(버전 1)");
        System.out.println("요솟수 :");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            System.out.println("arr[" + i + "] : ");
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr, n);

        System.out.println("오름 차순으로 정렬했습니다.");
        for(int i=0; i<n; i++){
            System.out.println("arr[" + i + "] : " + arr[i]);
        }
    }
}
