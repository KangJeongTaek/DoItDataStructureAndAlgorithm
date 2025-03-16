package ch02;

// 소수는 2와 홀수만으로 이루어져 있다.
// 소수는 그 이하의 소수로 나누어 봤을 대 안 나누어 떨어지면 소수
public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0; // 나눗셈 갯수
        int ptr = 0;  // 소수의 개수
        int[] prime = new int[500]
                ; // 소수를 저장하는 배열

        prime[ptr ++] = 2;

        for(int i = 3; i <= 1000; i += 2){
            int n;
            for (n = 1; n < ptr; n++){
                counter++;
                if(i % prime[n] == 0 ) break;
            }
            if(ptr == n) prime[ptr++] = i;
        }

        for(int i = 0; i < prime.length; i++){
            System.out.println(prime[i]);
        }
        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }
}
