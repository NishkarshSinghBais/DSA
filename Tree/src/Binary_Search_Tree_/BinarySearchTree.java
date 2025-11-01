package Binary_Search_Tree_;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    static public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    // Q1. Insert in BST

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // Q2. Key Exist or Not In BST

    public boolean isThere(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.val) {
            return isThere(root.left, key);
        } else if (root.val == key) {
            return true;
        } else {
            return isThere(root.right, key);
        }
    }

    // Q3. Delete A Node from A BST

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            root = delHelper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if ( key < root.val ) {
                if (root.left != null && root.left.val == key) {
                    root.left = delHelper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if ( root.right != null && root.right.val == key ){
                    root.right = delHelper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public TreeNode delHelper(TreeNode root){
        if ( root.left == null ){
            return root.right;
        } else if ( root.right == null ){
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode rightMost = findRightMost(root.left);
            rightMost.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findRightMost(TreeNode root){
        if ( root.right == null ){
            return root;
        }
        return findRightMost(root.right);
    }

    // Q4.

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(9);

        tree.inorder(tree.root);
        
    }
}
