package ch05;

public class EuclidGCD {

    // 두 수의 최대 공약수 구하기
    static int gcd(int x, int y){
        if(y == 0) return x;
        else return gcd(y,x % y);
    }

    // 세 수의 최대 공약수 구하기
    static int gcd2(int x, int y, int z){
        return gcd(gcd(x,y),z);
    }

    // 배열 a의 모든 요소의 최대 공약수를 구하는 메서드
    static int gcd3(int[] a){
        if(a.length >= 1){
            int result = a[0];
            for(int i = 1; i < a.length; i++){
                result = gcd(result,a[i]);
            }
            return result;
        }else{
            System.out.println("숫자를 2개 이상 입력하시오.");
            return -1;
        }
    }
}
