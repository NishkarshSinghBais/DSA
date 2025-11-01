package Binary_Tree_;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_Implementation {

    Node root;

    public BinaryTree_Implementation() {
        root = null;

    }

    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    public void preorder() {
        traversePreorder(root);
    }

    public void traversePreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        traversePreorder(root.left);
        traversePreorder(root.right);
    }

    public void inorder() {
        traverseInorder(root);
    }

    private void traverseInorder(Node root) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        System.out.print(root.val + " ");
        traverseInorder(root.right);
    }

    public void postorder(){
        traversePostorder(root);
    }

    public void traversePostorder(Node root){
        if ( root == null ){
            return;
        }
        traversePostorder(root.left);
        traversePostorder(root.right);
        System.out.print(root.val + " ");
    }
}
