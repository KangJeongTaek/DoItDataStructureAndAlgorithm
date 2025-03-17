package ch03;
// 선형 검색

import java.util.Scanner;

public class SeqSearch {

    //요솟수 n인 배열 a에서 key와 값이 같은 요소를 선형 검색

    static int seqSearch(int[] a, int n, int key){
        int i = 0;

        while(true){
            if(n == a.length) return -1;
            if(a[i] == key) return i;
            i++;
        }
    }

    // 실습 3-2
    static int seqSearchWithFor(int[] a, int n, int key){
        for(int i = 0; i < a.length; i++){
            if(a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < num; i++){
            System.out.println("x[" + i + "] :");
            x[i] = sc.nextInt();
        }

        System.out.println("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = seqSearch(x, num, ky);

        if(idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
