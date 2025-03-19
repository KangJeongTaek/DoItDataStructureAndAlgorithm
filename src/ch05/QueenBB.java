package ch05;

public class QueenBB {
    static int[] pos = new int[8];
    static boolean[] flag = new boolean[8]; // 같은 행의 중복하여 배치되는 것을 방지하기 위한 표시

    static void print(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d ", pos[i]);
        }
        System.out.println();
    }

    static void set(int i ){
        for (int j = 0; j < 8; j++){
            if(!flag[j]){
                pos[i] = j;
                if(i == 7) print();
                else {
                    flag[j] = true;
                    set(i + 1);
                    flag[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
