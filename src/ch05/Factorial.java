package ch05;

public class Factorial {

    static int factorial(int n) {
        if(n > 0) return n * factorial(n-1);
        else return 1;
        //return (n > 0) ? n * factorial(n - 1) : 1;
    }
}
