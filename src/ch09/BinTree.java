package ch09;

import java.util.Comparator;

public class BinTree<K,V> {

    static class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key, V data,Node<K,V> left, Node<K,V> right){
        this.key = key;
        this.data= data;
        this.left = left;
        this.right = right;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        void print(){
            System.out.println(data);
        }
    }

    private Node<K,V> root; // 루트

    private Comparator<? super K> comparator = null; //비교자

    // 생성자
    public BinTree(){ //자연 순서에 따라 키값을 비교
        root = null;
    }

    // 생성자
    public BinTree(Comparator<? super K> comparator){ // 비교자로 키값을 비교
        this();
        this.comparator = comparator;
    }

    //두 키값을 비교 Comparable을 구현한 클래스(자연 순서를 갖는) 클래스들은 정상적으로 실행외 되겠지만, 그렇지 않고 comparator가 null인 경우 런타임 예외(ClassCastException)가 발생할 수 있다.
    private int comp(K key1, K key2){
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 키로 검색
    public V search(K key){
        Node<K,V> p = root; // 루트에 주목

        while(true){
            if( p == null)  // 더 이상 진행할 수 없으면
                return null;  // 검색 실패
            int cond = comp(key, p.getKey()); // key와 노드 p의 키값을 비교
            if(cond == 0)  // 같으면
                return p.getValue();
            else if (cond <0) // key 가 작으면
                p = p.left; // 왼쪽 서브트리
            else // key가 크면
                p = p.right; // 오른쪽 서브트리
        }
    }

    // node를 루트로 하는 서브트리에 노드<K,V>를 삽입
    private void addNode(Node<K,V> node, K key, V data){
        int cond = comp(key,node.getKey());
        if(cond == 0)
            return; //key가 이미 이진트리에 있음.
        else if(cond<0) {
            if(node.left == null)
                node.left = new Node<K,V>(key,data,null,null);
            else
                addNode(node.left, key, data);
        }else{
            if(node.right == null)
                node.right = new Node<K,V>(key,data,null,null);
            else
                addNode(node.right, key, data);
        }
    }

    // 노드를 삽입
    public void add(K key, V data){
        if( root == null)
            root = new Node<>(key,data,null,null);
        else
            addNode(root, key, data);
    }
}
