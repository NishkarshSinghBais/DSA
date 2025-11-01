package Linked_List;

import java.util.ArrayList;

public class LL {

    Node head;
    Node tail;
    int size;

    LL() {
        this.size = 0;
    }

    int length() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void displayLength() {
        System.out.println("Length = " + length());
    }

    void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }

    void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    void deleteLast() {
        if (size <= 1) {
            deleteFirst();
            return;
        }
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
    }

    void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node prev = get(index - 1);
        prev.next = prev.next.next;
    }

    Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    private class Node {


        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // Questions Now

    // Q1. Remove Duplicates

    void removeDuplicate() {
        Node node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    // Q2. Merge Two Sorted Linked List

    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }
        while (s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }
        return ans;
    }

    // Q3. Middle of LL //Optimal Approach

    Node middle() {

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2 + 1;
        temp = head;
        while (temp != null) {
            mid = mid - 1;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    void displaymiddle() {
        Node mid = middle();
        System.out.println("Middle = " + mid.val);
    }

    // Q#. Mid of LL / Slow and Fast Pointer

    Node mid(){

        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void displaymid() {
        Node mid = middle();
        System.out.println("Mid = " + mid.val);
    }

    // Q4. Reverse a Linked List // Returning new head // Iterative

    Node reverse(Node head){

        Node temp = head;
        Node prev = null;

        while ( temp != null ){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    void displayrev(Node head) {
        Node n = reverse(head);
        System.out.print( " Reversed : " );
        while ( n != null ) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
    }

    // Q5. Reverse a Linked List // Returning new head // Recursion

    Node reverseLL(Node head){

        if ( head == null || head.next == null ){
            return head;
        }
        Node newhead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newhead;
    }

    void displayreverse(Node head) {
        Node n = reverseLL(head);
        System.out.print( " Reversed Wali : " );
        while ( n != null ) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
    }

    // Q6. Detect a loop in LL

    boolean loop(){

        if ( head == null ){
            return false;
        }
        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ){
                return true;
            }
        }
        return false;
    }

    // Q7. Starting Point of Loop in LL

    Node startpoint() {

        if ( head == null ){
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Q8. Length of Loop

    int loopslength(Node slow, Node fast){

        int count = 1;
        slow = slow.next;

        while ( slow != fast ){
            count++;
            slow = slow.next;
        }
        return count;
    }

    int lengthloop(){

        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ){
                return loopslength(slow, fast);
            }
        }
        return 0;
    }

    // Q9. Is LL is palindrome or not

    Node revnexthalf(Node head){

        Node temp = head;
        Node prev = null;

        while ( temp != null ){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    boolean palindrome(){

        if ( head == null || head.next == null ){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
            Node newhead = revnexthalf(slow.next);
            Node first = head;
            Node second = newhead;

            while ( second != null ){
                if ( first.val != second.val ){
                    revnexthalf(newhead);
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            revnexthalf(newhead);
        return true;
    }

    // Q10. Delete Nth Node From Last

    Node deletenode(int n) {

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node delnode = slow.next;
        slow.next = slow.next.next;
        return head;
    }

    // Q11. Delete Middle Node of LL

    Node delmid(){

        if ( head == null || head.next == null ){
            return null;
        }

        Node slow = head;
        Node fast = head;

        fast = fast.next.next;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if ( slow.next != null ) {
            slow.next = slow.next.next;
        }
        return head;
    }

    // Q12. Sort Linked List

    Node mergesortLL(Node left, Node right){

        Node dummynode = new Node(-1);
        Node temp = dummynode;

        while ( left != null && right != null ){
            if ( left.val < right.val ){
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while ( left != null ){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while ( right != null ){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return dummynode.next;
    }
    Node findmid(Node head){

        if ( head == null || head.next == null ){
            return head;
        }
        Node slow = head;
        Node fast = head.next;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    Node sortLL(Node head){

        if ( head == null || head.next == null ){
            return head;
        }
        Node middle = findmid(head);

        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);

        return mergesortLL(left, right);
    }

    // Q13. Find pairs with given sum // Syntax error possible

    ArrayList<ArrayList<Integer>> findpair(int target, Node head){

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if ( head == null ){
            return list;
        }

        Node temp1 = head;
        while ( temp1 != null ){
           Node temp2 = temp1.next;
           while ( temp2 != null ){
               if ( temp1.val + temp2.val == target ){
                   ArrayList<Integer> pair = new ArrayList<>();
                   pair.add(temp1.val);
                   pair.add(temp2.val);
                   list.add(pair);
               }
               temp2 = temp2.next;
           }
           temp1 = temp1.next;
        }
        return list;
    }
}
