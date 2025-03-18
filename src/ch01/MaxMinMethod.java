package ch01;

public class MaxMinMethod {
    public static void main(String[] args) {
        System.out.println(max4(3,2,1,7));

        System.out.println(min3(3,2,1));
    }

//    4개의 최대값을 구하는 max4 메서드
    static int max4(int a, int b, int c, int d) {
        int max = a;

        if(max < b) max = b;
        if(max < c) max = c;
        if(max < d) max = d;

        return max;
    }
//   세 값의 최솟값을 구하는 min3 메서드
    static int min3(int a, int b, int c) {
        int min = a;

        if(min > b) min = b;
        if(min > c) min = c;

        return min;
    }

//   네 값의 최솟값을 구하는 min4 메서드
    static int min3(int a, int b, int c, int d) {
    int min = a;

    if(min > b) min = b;
    if(min > c) min = c;
    if(min > d) min = d;

    return min;
    }
}
