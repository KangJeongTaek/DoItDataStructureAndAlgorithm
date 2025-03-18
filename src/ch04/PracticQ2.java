package ch04;

import java.util.EmptyStackException;

//임의의 객체형 데이터를 쌓을 수 있는 제네릭 스택 클래스 Stack<E>를 작성하세요.
public class PracticQ2<E> {
    private E[] stk;
    private int capacity;
    private int ptr;

    public PracticQ2(int capacity) {
        ptr = 0;
        try {
            stk = (E[]) new Object[capacity];
        }catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    public E push(E e) throws StackOverflowError{
        if(ptr >= capacity) throw new StackOverflowError();
        return stk[ptr++] = e;
    }

    public E pop() throws EmptyStackException{
        if(ptr <= 0) throw new EmptyStackException();
        return stk[--ptr];
    }

    public E peek() throws EmptyStackException{
        if(ptr <= 0) throw new EmptyStackException();
        return stk[ptr - 1];
    }

    public void clear(){
        ptr = 0;
    }

    public int indexOf(E e){
        for (int i = ptr - 1; i > 0; i--){
            if (stk[i].equals(e)) return i;
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }
    // 스택에 쌓여 있는 데이터 개수를 반환
    public int size(){
        return ptr;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty(){
        return ptr <= 0;
    }

    //스택이 가득 찼는가?
    public boolean isFull(){
        return ptr >= capacity;
    }

    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(){
        if(ptr <= 0) System.out.println("스택이 비어있습니다.");
        else{
            for (int i = 0; i < ptr ; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
