package ch05;

public class EightQueen {
    static boolean[] flag_a = new boolean[8]; // 가로(j행)에 아직 배치하지 않음
    static boolean[] flag_b = new boolean[15]; // ↗ 대각선에 아직 배치하지 않음
    static boolean[] flag_c = new boolean[15]; // ↖ 대각선에 아직 배치하지 않음
    static int[] pos = new int[8];

    static void print(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j = 0; j < 8; j++){
            if(!flag_a[j] && !flag_b[i + j] && !flag_c[ i - j + 7]){
                pos[i] = j;
                if(i == 7) print();
                else {
                    flag_a[j] = true;
                    flag_b[i + j] = true; // 우상향 그래프 (0,8) ,(1,7), (2,6) 은 모두 i +j 가 동일
                    flag_c[i - j + 7] = true; //좌상향 그래프 (0,0) ,(1,1), (2,2) 는 모두 i -j  가 동일 단 i - j가 0이 되는 경우가 존재하므로 +7을 해주어서 음수 방지!
                    set(i + 1);
                    flag_a[j] = false;
                    flag_b[i + j] = false;
                    flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
