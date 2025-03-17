package ch03;

import java.util.Scanner;

public class BinSearch {

    static int binSearch(int a[], int n, int key){
        int pl = 0; // 검색 범위의 첫 인덱스
        int pr = n - 1;  // 검색 범위의 끝 인덱스

        do{
            int pc = (pl + pr) / 2;
            if(a[pc] == key) return pc;
            else if(a[pc] < key) pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 좁힘
            else pr = pc  - 1; // 검색 범위를 앞쪽 절반으로 좁힘
        }while(pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = sc.nextInt();
        int[]x = new int[num];

        System.out.println("오름차순으로 입력하시오.");

        System.out.println("x[0] : "); // 첫번 째 요소
        x[0] = sc.nextInt();

        for(int i = 1; i < num; i++){
            do{
                System.out.println("x["+i+"] : ");
                x[i] = sc.nextInt();
            }while(x[i] < x[i-1]);
        }

        System.out.println("검색할 값 : ");
        int ky= sc.nextInt();

        int idx = binSearch(x, num, ky);

        if(idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println(" 그 값은 x[" + idx + "]에 있습니다.");
    }
}
