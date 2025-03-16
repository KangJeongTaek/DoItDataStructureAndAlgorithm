package ch02;

import java.util.Arrays;
import java.util.Scanner;

// 배열에 대해
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    static void reverse(int[] a){
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    static int sumOf(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    
    static void copy(int[] a,int[] b){
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
    }
    
    static void rcopy(int[] a, int[] b){
        for (int i = 0; i <a.length; i++){
            b[i] = a[a.length -i - 1];
        }
    }
}
