package ch06;

import ch04.IntStack;

import static ch06.BubbleSort2.swap;


public class QuickSort2 {

    static void quickSort(int[] arr, int left, int right){
        IntStack lstack = new IntStack(right - left  + 1); // 나눌 범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
        IntStack rstack = new IntStack(right - left  + 1); // 나눌 범위의 오른쪽 끝 요소의 인덱스를 젖하는 스택

        lstack.push(left);
        rstack.push(right);

        while(!lstack.isEmpty()){
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot = arr[(left + right) / 2];

            do{
                while (arr[pl] < pivot) pl ++;
                while (arr[pr] > pivot) pr --;
                if(pl <= pr) swap(arr,pl++,pr--);
            }while(pl <= pr);

            if(left < pr){
                lstack.push(left); //왼쪽 그룹 범위의
                rstack.push(pr); // 인덱스를 푸시
            }
            if(pl < right){
                lstack.push(pl); // 오른쪽 그룹 범위의
                rstack.push(right); //인덱스를 푸시
            }
        }
    }
}
