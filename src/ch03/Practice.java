package ch03;

import java.util.Arrays;

public class Practice {

    //실습 3-3의 seqSearchSen 메서드를 while 문 대신 for 문을 사용하여 수정한 프로그램을 작성하시오. Q1
    static int seqSearchSenFor(int[] a, int n, int key) {
        int i =0;
        a[n] = key;
        for(i = 0 ;i < n ; i++){
            if(a[i] == key) return i;
        }
        return -1;
    }

    // 오른쪽 선형 검색의 스캐닝 과정을 자세히 출력하는 프로그램을 작성하시오. 이때 각 행의 맨 왼쪽에 현재 선택한
    // 요소의 인덱스를 출력하고
    // 현재 선택한 요소 위에 기호 *를 출력하세요. Q2
    static void seqSearch(int[] a, int n, int key) {
        int i =0;
        System.out.print(" |");
        for(i = 0 ;i < n ; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(i = 0 ;i < n * 3 ; i++){
            System.out.print("-");
        }
        System.out.println();
        for(i = 0 ;i < n ; i++){
            System.out.print(" | ");
            System.out.print(" ".repeat(i * 2));
            System.out.println("*");
            System.out.print(i + "|");
            for(int element : a){
                System.out.print(" " + element);
            }
            System.out.println();
            if(a[i] == key) {
                System.out.println("그 값은 x[" + i + "]에 있습니다.");
                return;
            }
        }
        System.out.println("값을 찾지 못 했습니다.");
    }

    // 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고, 일치하는 요솟수를
    // 반환하는 메서드를 작성하시오. 예를 들어 요솟수가 8인 배열 a의 요소가 {1,9,3,9,5,6,7,9}이고 key가 9 일 때
    // 배열 idx에 {1,3,7}을 저장하고 3을 반환합니다. Q3
    static int searchIdx(int[] a,int n, int key, int[] idx){
        int dx = 0;
        for(int i = 0 ;i < n ; i++){
            if(a[i] == key){
                idx[dx++] = i;
            }
        }
        System.out.println(Arrays.toString(idx));
        return dx;
    }

    //오른쪽처럼 이진 검색 과정을 자세히 출력하는 프로그램을 작성하시오.
    //각 행의 맨 왼쪽에 현재 선택한 요소의 인덱스를 출력하고, 검색 범위의 첫 요소 위에 <-, 끝 요소 위에 ->,
    // 현재 선택한 중앙 요소 위에 +를 출력하시오.
    static void binSearch(int[] a, int key){
        int n  = a.length;
        System.out.print("  |");
        for(int i = 0 ;i < n ; i++){
            System.out.printf(" %2d",i);
        }
        System.out.println();
        System.out.print("--+");
        for(int i = 0 ;i < n *3 + 2 ; i++){
            System.out.print("-");
        }
        System.out.println();
        int firstIndex = 0;
        int lastIndex = a.length - 1;
        while (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            System.out.print("  | ");
            System.out.print(" ".repeat(firstIndex * 3));
            System.out.print("<-");
            System.out.print(" ".repeat((mid - firstIndex) * 3));
            System.out.print("+");
            System.out.print(" ".repeat(Math.max(0, (lastIndex - mid) * 3 - 2)));
            System.out.print("->");
            System.out.println();
            System.out.printf("%2d|",mid);
            for(int j = 0; j <n ; j++){
                System.out.printf(" %2d",a[j]);
            }
            System.out.println();

            if(a[mid] == key){
                System.out.println(key +"는 x[" + mid + "]에 있습니다.");
                return;
            }else if(a[mid] > key){
                lastIndex = mid - 1;
            }else{
                firstIndex = mid + 1;
            }
        }
        System.out.println("값을 찾지 못 했습니다.");
    }
    public static void main(String[] args) {
//        int[] a = {6,5,3,2,1,9,8};

//        int n = a.length;
//        int key = 3;
//        seqSearch(a,n,key);


//        int[] a =  {1,9,3,9,5,6,7,9};
//        int n = 8;
//        int[] idx = new int[n];
//
//        searchIdx(a,n,9,idx);

        int[] a = {1,2,3,5,6,8,9};
        int key = 4;
        binSearch(a, key);
    }
}
