package Linked_List;

public class CLL {

    private Node head;
    private Node tail;

    void insert(int val){
        Node node = new Node(val);
        if ( head == null ){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    void delete(int val){
        Node node = head;
        if ( head == null ){
            return;
        }
        if (node.val == val) {
            head = head.next; // check for node.next too
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if ( n.val == val ){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while ( node != head );
    }

    void display(){
        Node node = head;
        if ( head != null ){
            do {
                System.out.print(node.val + " -> ");
                node = node.next;
            } while ( node != head );
        }
    }

    class Node{

        int val;
        Node next;

         Node(int val){
            this.val = val;
        }

        Node(int val, Node next){
             this.val = val;
             this.next = next;
        }
    }
}
