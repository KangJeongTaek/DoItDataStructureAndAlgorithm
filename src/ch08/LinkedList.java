package ch08;

import java.util.Comparator;

public class LinkedList<E> {


    private Node<E> head;  // 머리 포인터
    private Node<E> crnt; // 선택 포인터

    public LinkedList(){
        head = crnt= null;
    }

    public E search(E obj, Comparator<? super E> cmp){
        Node<E> ptr = head; // 현재 스킨 중인 노드
        while (ptr != null){
            if(cmp.compare(obj,ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; // 다음 노드 선택
        }
        return null; // 검색 실패
    }

    public void addFirst(E obj){
       Node<E> ptr = head; // 삽입 전의 머리 노드
       head = crnt = new Node<>(obj,ptr);
    }

    public void addLast(E obj){
        if(head == null){
            addFirst(obj);
        }else{
            Node<E> ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<>(obj,null);
        }
    }

    public void removeFirst(){
        if(head != null){
            head = crnt = head.next;
        }
    }

    public void removeLast(){
        if(head != null){
            if(head.next == null){
                removeFirst();
            }else{
                Node<E> ptr = head; // 스캔 중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

                while(ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    public void remove(Node p){
        if(head != null){
            if( p == head){ // p가 머리 노드면
                removeFirst(); // 머리 노드 삭제
            }else{
                Node<E> ptr = head;
                while(ptr.next != p){
                    ptr = ptr.next;
                    if(ptr == null) return; // p가 리스트에 없음
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode(){
        remove(crnt);
    }

    public void clear(){
        while(head != null){
            removeFirst();
        }
        crnt = null;
    }

    public boolean next(){
        if(crnt == null || crnt.next == null){
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode(){
        if(crnt == null){
            System.out.println("선택한 노드가 없습니다.");
        }else{
            System.out.println(crnt.data);
        }
    }

    public void dump(){
        Node<E> ptr = head;
        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    class Node<E>{
        private E data;
        private Node<E> next;
        
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

}
