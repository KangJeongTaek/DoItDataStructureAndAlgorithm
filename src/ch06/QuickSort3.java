package ch06;

public class QuickSort3 {

    static void swap(int[] arr, int idx1, int idx2){
        int i = idx1; idx1 = idx2; idx2 = i;
    }

    static int sort3elem(int []x, int a, int b, int c){
        if(x[b] < x[a]) swap(x,a,b);
        if(x[c] > x[b]) swap(x,c,b);
        if(x[b] < x[a]) swap(x,a,b);
        return b;
    }

    static void quickSort(int[] arr, int left, int right){
        int pl = left;
        int pr = right;
        int m = sort3elem(arr,pl,(pl+pr) /2,pr); // 처음, 가운데, 끝 요소르 정렬
        int x = arr[m];

        swap(arr,m,right - 1); // 가운데 요소와 끝에서 두 번째 요소를 교환
        pl++; //왼쪽 커서를 오른쪽으로 1만큼 진행
        pr-= 2; //오른쪽 커서를 왼쪽으로 2만큼 진행

        do{
            while(arr[pl] < x) pl++;
            while(arr[pr] > x) pr--;
            if(pl<=pr) swap(arr,pl++,pr--);
        }while(pl<=pr);

        if(left <pr) quickSort(arr,left,pr);
        if(right > pl)  quickSort(arr,pl,right);
    }
}
