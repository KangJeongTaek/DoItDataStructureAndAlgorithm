package ch04;

public class IntStack {

    private int[] stk; //스택용 배열
    private int capacity; // 스택 용량
    private int ptr; // 스택 포인터

    // 실행시 예외; 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    //생성자
    public IntStack(int maxlen) {
        ptr =0;
        capacity = maxlen;
        try{
            stk = new int[capacity];
        }catch(OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException {
        if(ptr >= capacity) throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 팝
    public int pop() throws EmptyIntStackException {
        if(ptr <= 0) throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크
    public int peek() throws EmptyIntStackException {
        if(ptr <= 0) throw new EmptyIntStackException();
        return stk[ptr -1];
    }

    // 스택을 비움
    public void clear(){
        ptr = 0;
    }

    // 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x){
        for (int i = ptr - 1; i > 0 ; i--) { //top부터 탐색
            if(stk[i] == x) return i;
        }
        return -1;
    }

    // 스택의 용량을 반환
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
