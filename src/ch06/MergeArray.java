package ch06;

public class MergeArray {

    static void merge(int [] a,int na, int[]b ,int nb,int[] c){
        int pa = 0;
        int pb = 0;
        int pc= 0;

        while(pa<nb && pb<nb){ // 작은 쪽 값은 C에 저장
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }

        while(pa <na) c[pc++] = a[pa++]; // a에 남아있는 요소 복사

        while(pb <nb) c[pc++] = b[pb++]; // b에 남아있는 요소 복사
    }
}
