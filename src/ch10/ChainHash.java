package ch10;

public class ChainHash<K,V> {

    class Node<K,V>{
        private K key; //키값
        private V data; // 데이터
        private Node<K,V> next; // 다음 노드에 대한 참조

        //생성자
        Node(K key, V data, Node<K,V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey(){
            return key;
        }
        V getValue(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();
        }


    }

    private int size;
    private Node<K,V>[] table;

    public ChainHash(int capacity){
        try{
            table = new Node[capacity];
            this.size = capacity;
        }catch(OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hashCode(Object key){
        return key.hashCode() % size;
    }

    // 키값이 key인 요소를 탐색(데이터를 반환)
    public V search(K key){
        int hash = hashCode(key);
        Node<K,V> p = table[hash];

        while(p != null){
            if(p.key.equals(key))
                return p.getValue();
            p = p.next;
        }
        return null;
    }
    
    // 키값이 key이고 데이터가 data인 요소를 추가
    public int add(K key, V value){
        int hash = hashCode(key); // 추가할 데이터의 해시값
        Node<K,V> p = table[hash];  // 선택 노드
        
        while(p != null){
            if(p.key.equals(key)) // 이 키값은 이미 등록됨
                return 1;
            p = p.next; // 다음 노드를 선택
        }
        Node<K,V> temp = new Node<>(key, value, table[hash]);
        table[hash] = temp; // 노드를 삽입
        return 0;
    }

    // 키값이 key인 요소를 삭제
    public int remove(K key){
        int hash = hashCode(key); // 삭제할 데이터의 해시값
        Node<K,V> p = table[hash]; // 선택 노드
        Node<K,V> pp = null; //바로 앞의 선택 노드
        while(p != null){
            if(p.getKey().equals(key)){
                if(pp == null)
                    table[hash] = p.next;
                else
                    pp.next = p.next;
                return 0;
            }
            pp = p;
            p = p.next; // 다음 노드를 선택
        }
        return 1; // 그 키값은 없음
    }

    // 해시 테이블을 덤프
    public void dump(){
        for(int i = 0; i< size ; i ++){
            Node<K,V> p = table[i];
            System.out.printf("%02d ",i);
            while(p != null){
                System.out.printf(" -> %s (%s)",p.getKey(),p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
