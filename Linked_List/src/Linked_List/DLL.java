package Linked_List;

import java.util.ArrayList;

public class DLL {

    Node head;
    Node tail;

    void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if ( head != null ){
            head.prev = node;
        }
        head = node;
    }

    void insertLast(int val){
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if ( head == null ){
            node.prev = null;
            head = node;
            return;
        }
        while ( last.next != null ){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    void insert(int after, int val){
        Node p = find(after);
        if ( p == null ){
            System.out.println("not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        if ( node.next != null ){
            node.next.prev = node;
        }
    }

    Node find(int val){
        Node node = head;
        while ( node != null ){
            if ( node.val == val ){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    void display(){
        Node temp = head;
        while ( temp != null ){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    private class Node{

        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    // Q1. Delete all occurrences of a key

    Node deloccurrences(int key){

        if ( head == null ){
            return null;
        }

        Node temp = head;

        while ( temp != null ){
            if ( temp.val == key ){
                if ( temp == head ) {
                    head = temp.next;
                    if ( head != null ) {
                        head.prev = null;
                    }
                    } else {
                        if ( temp.prev != null ){
                            temp.prev.next = temp.next;
                        }
                        if ( temp.next != null ){
                            temp.next.prev = temp.prev;
                        }
                    }
            }
            temp = temp.next;
        }
        return head;
    }

    // Q2. Find pairs with given sum in DLL

    static Node findtail(Node head){
        Node temp = head;
        while ( temp != null && temp.next != null ){
            temp = temp.next;
        }
        return temp;
    }

    public static ArrayList<ArrayList<Integer>> findpair(int target, Node head){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node left = head;
        Node right = findtail(head);

        while ( left.val < right.val ){
            if ( left.val + right.val == target ){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                list.add(pair);

                left = left.next;
                right = right.prev;
            }
            else if ( left.val + right.val < target ){
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return list;
    }

    // Q3. Remove duplicates from doubly Linked list

    Node duplicateremove() {

        if (head == null) {
            return null;
        }
        Node temp = head;

        while ( temp != null && temp.next != null ) {
            Node nextnode = temp.next;
            while ( nextnode != null && nextnode.val == temp.val ){
                nextnode = nextnode.next;
            }
            temp.next = nextnode;
            if ( nextnode != null ){
                nextnode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
