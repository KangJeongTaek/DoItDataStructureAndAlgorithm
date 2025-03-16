package ch01;

public class TriangleMethod {
    public static void main(String[] args) {
        spira(4);
        nspira(4);
    }
    //6 3 3
    //4 2 2
    //2 1 1
    static void spira(int n){
        for(int i=1; i<=n; i++){
            for(int j = n; j>=i + 1; j--){
                System.out.print(" ");
            }
            for(int j = 1; j<= (i * 2) - 1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void nspira(int n){
        for(int i=1; i<=n; i++){
            for(int j = n; j>=i + 1; j--){
                System.out.print(" ");
            }
            for(int j = 1; j<= (i * 2) - 1 ; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
