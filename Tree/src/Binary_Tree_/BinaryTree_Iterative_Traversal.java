package Binary_Tree_;

import java.util.*;

public class BinaryTree_Iterative_Traversal {
    TreeNode root;

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        // Q1. Level Order traversal

        public List<List<Integer>> levelorder(TreeNode root) {

            List<List<Integer>> list = new LinkedList<>(); // Make List of Lists of Integer
            Queue<TreeNode> queue = new LinkedList<>(); // Make a Queue of LinkedList
            if (root == null) {
                return list;
            }
            queue.offer(root); // Add root to the queue
            while (!queue.isEmpty()) {
                int size = queue.size(); // Take size of the queue
                // Initially size will be one as root comes first
                List<Integer> sublist = new LinkedList<>(); // Make a list of integer to store values
                for (int i = 0; i < size; i++) { // Run for loop till the size of queue
                    TreeNode node = queue.poll(); // Take out first one from the queue
                    sublist.add(node.val); // Add it to the sublist

                    if (node.left != null) {
                        queue.offer(node.left); // add it to the queue
                    }
                    if (node.right != null) {
                        queue.offer(node.right); // add it to the queue
                    }
                }
                list.add(sublist); // add sublist to the list after for loop ends first
            }
            return list;
        }

        // Q2. Pre Order Traversal // Iterative

        public List<Integer> preorder(TreeNode root) {

            List<Integer> list = new ArrayList<>(); // Make a List of Integer

            if (root == null) {
                return list;
            }
            Stack<TreeNode> st = new Stack<>(); // Make a stack of TreeNode
            st.push(root); // push root into the stack
            while (!st.isEmpty()) {
                TreeNode node = st.pop(); // take out last pushed element from the stack & store it in
                list.add(node.val); // add it to the list
                if (node.right != null) {
                    st.push(node.right); // push node's right to the stack if not empty
                } // check for node's right first always to push in node's right into the stack first
                if (node.left != null) {
                    st.push(node.left); // // push node's left to the stack if not empty
                }
            }
            return list;
        }

        // Q3. In Order Traversal // Iterative

        public List<Integer> inorder(TreeNode root) {
            List<Integer> list = new ArrayList<>(); // Make a list of integer
            Stack<TreeNode> st = new Stack<>(); // Make a Stack of TreeNode
            TreeNode node = root; // Assign root to node

            while (node != null || !st.isEmpty()) {
                while (node != null) {
                    st.push(node); // push node to the stack
                    node = node.left; // make node, node's left
                }
                node = st.pop(); // pop out top most from the stack
                list.add(node.val); // add node's value to the list
                node = node.right; // make node, node's right
            }
            return list;
        }

        // Q4. Post Order Traversal // Iterative // Using 1 Stack

        public List<Integer> postorder(TreeNode root) {

            List<Integer> list = new ArrayList<>(); // Make a list of integer
            Deque<TreeNode> queue = new LinkedList<>(); // Make a dequeue

            if (root == null) {
                return list;
            }

            TreeNode current = root;

            while (current != null || !queue.isEmpty()) {
                if (current != null) {
                    queue.offer(current);
                    current = current.left;
                } else {
                    TreeNode temp = queue.peekLast().right;
                    if (temp == null) {
                        temp = queue.pollLast();
                        list.add(temp.val);
                        while (!queue.isEmpty() && temp == queue.peekLast().right) {
                            temp = queue.pollLast();
                            list.add(temp.val);
                        }
                    } else {
                        current = temp;
                    }
                }
            }
            return list;
        }

        // Q5. Zig-Zag Traversal in Binary Tree

        public List<List<Integer>> zigzagorder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            boolean left2right = true;

            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> sublist = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (left2right) {
                        TreeNode current = deque.pollFirst();
                        sublist.add(current.val);
                        if (current.left != null) {
                            deque.offerLast(current.left);
                        }
                        if (current.right != null) {
                            deque.offerLast(current.right);
                        }
                    } else {
                        TreeNode current = deque.pollLast();
                        sublist.add(current.val);
                        if (current.right != null) {
                            deque.offerFirst(current.right);
                        }
                        if (current.left != null) {
                            deque.offerFirst(current.left);
                        }
                    }
                }
                list.add(sublist);
                left2right = !left2right;
            }
            // Collections.reverse(list); // Better Use list.add(0, sublist); add at 0th index everytime.
            return list;

        }

        // Q6, Post Order Traversal // Iterative // Using 2 Stack

        public List<Integer> postorder2stack(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> st1 = new Stack<>();
            Stack<TreeNode> st2 = new Stack<>();

            if (root == null) {
                return list;
            }

            st1.push(root);
            while (!st1.isEmpty()) {
                root = st1.pop();
                st2.push(root);
                if (root.left != null) {
                    st1.push(root.left);
                }
                if (root.right != null) {
                    st1.push(root.right);
                }
            }
            while (!st2.isEmpty()) {
                list.add(st2.pop().val);
            }
            return list;
        }


        public static void main(String[] args) {

            BinaryTree_Iterative_Traversal tree = new BinaryTree_Iterative_Traversal();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.right.right.right = new TreeNode(8);

            System.out.print("Level Order Iteration : ");
            List<List<Integer>> ans = root.levelorder(root);
            System.out.println(ans);

            System.out.print("Pre Order Iteration : ");
            List<Integer> ans1 = root.preorder(root);
            System.out.println(ans1);

            System.out.print("In Order Iteration : ");
            List<Integer> ans2 = root.inorder(root);
            System.out.println(ans2);

            System.out.print("Post Order Iteration : ");
            List<Integer> ans3 = root.postorder(root);
            System.out.println(ans3);

            System.out.print("Zig Zag Order Iteration : ");
            List<List<Integer>> ans4 = root.zigzagorder(root);
            System.out.println(ans4);

//            List<Integer> ans5 = root.postorder2stack(root);
//            System.out.println(ans5);
        }
    }
}
