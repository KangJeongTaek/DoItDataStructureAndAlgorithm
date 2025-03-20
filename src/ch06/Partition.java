package ch06;

public class Partition {

    // 배열의 요소값 바꾸기
    static void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // 배열을 나누기
    static void partition(int[] arr, int n){
        int pl = 0 ; // 왼쪽 커서
        int pr = n - 1; //우측 커서
        int pivot = arr[n/2] ; //피벗 (가운데 요소)

        do{
            while(arr[pl] < pivot) pl++;
            while(arr[pr] > pivot) pr--;
            if(pl <= pr) swap(arr, pl++, pr--);
        }while (pl<=pr);

        System.out.println("피벗값은 " + pivot  + "입니다.");

        System.out.println("피벗 이하의 그룹");
        for(int i = 0 ; i <= pl -1; i++){ // a[0] ~a[pl - 1]
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        if(pl > pr + 1){
            System.out.println("피벗과 같은 그룹");
            for(int i = pr + 1; i <= pl - 1; i++){ // a[pr + 1] ~ a[pl -1]
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        System.out.println("피밧 이상의 그룹");
        for(int i = pr + 1; i < n ; i ++){ // a[pr +1] ~ a[n -1]
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
