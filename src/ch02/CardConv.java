package ch02;

import java.util.Arrays;
import java.util.Scanner;

// 입력받은 10진수를 2진수~36진수로 기수 변환하여 출력
public class CardConv {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        char[] dno;
        int retry;

        System.out.println("10진수를 기수로 변환합니다.");
        do{
            do{
                System.out.println("변환하려는 음이 아닌 정수 :");
                no = stdIn.nextInt();
            } while(no <0);
            do{
                System.out.println("어떤 진수로 변환할까요(2~36) : ");
                cd = stdIn.nextInt();
            }while(cd < 2 || cd > 36);

            dno = cardConv(no,cd);

            System.out.println(cd + "진수로 변경");
            for(int i = 0; i < dno.length; i++){
                System.out.print(dno[i]);
            }
            System.out.println("입니다.");

            System.out.println("한번 더 할까요?");
            retry = stdIn.nextInt();
        }while(retry == 1);
    }
    // x = 10진수 수
   //    r = 변환할 진수
    static char[] cardConv(int x, int r){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] d = new char[32];

        do{
            d[digits++] = dchar.charAt(x % r); //r로 나눈 나머지를 저장
            x /= r;
        }while (x != 0);

        for(int i = 0; i < digits / 2; i++){
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return Arrays.copyOf(d,digits);
    }
}
