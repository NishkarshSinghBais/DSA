package Binary_Tree_;

import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Binary_Tree_Questions {

    TreeNode root;

    static public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }

        // Q1. Maximum Depth // Height of Tree // Recursive

        public int maxDepth(TreeNode root){

            if ( root == null ){
                return 0;
            }
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);

            int maxi = Math.max(lh, rh) + 1;

            return maxi;
        }

        // Q2. Check Tree is Balanced or Not

        public boolean isBalanced(TreeNode root){
            return dfsHeight(root) != -1;
        }

        public int dfsHeight(TreeNode root){
            if ( root == null ) {
                return 0;
            }
            int lh = dfsHeight(root.left);
            int rh = dfsHeight(root.right);
            if ( lh == -1 || rh == -1 ){
                return -1;
            }
            if ( Math.abs(lh - rh) > 1){
                return -1;
            }
            return Math.max(lh, rh) + 1;
        }

        // Q3. Diameter of Tree // Maximum Distance from one node to another

        public int diameter(TreeNode root){
            int[] dia = new int[1];
            calculateHeight(root, dia);
            return dia[0];
        }

        public int calculateHeight(TreeNode node, int[] dia){
            if ( node == null ){
                return 0;
            }

            int lh = calculateHeight(node.left, dia);
            int rh = calculateHeight(node.right, dia);

            dia[0] = Math.max(dia[0], lh + rh);

            return Math.max(lh, rh) + 1;
        }

        // Q4.Average of levels in binary tree

        public List<Double> calculateAverage(TreeNode root){

            List<Double> list = new LinkedList<>();
            if ( root == null ){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while ( !queue.isEmpty() ){
                double average = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    average += current.val;
                    if ( current.left != null ){
                        queue.offer(current.left);
                    }
                    if ( current.right != null ){
                        queue.offer(current.right);
                    }
                }
                average = average / size;
                list.add(average);
            }
            return list;
        }

        // Q5. Level order successor of a node

        public int successor(TreeNode root, int key){

            List<Double> list = new LinkedList<>();
            if ( root == null ){
                return -1;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while ( !queue.isEmpty() ){
                TreeNode current = queue.poll();
                if ( current.left != null ){
                    queue.offer(current.left);
                }
                if ( current.right != null ){
                    queue.offer(current.right);
                }
                if ( current.val == key ){
                    break;
                }
                }
            return queue.peek().val;
        }

        // Q6. Zig-Zag Traversal in Binary Tree

        public List<List<Integer>> zigzag(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            boolean left2right = true;

            while (!deque.isEmpty() ) {
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

        // Q7. Binary Tree Right Side View

        public List<Integer> rsv(TreeNode root) {

            List<Integer> list = new LinkedList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return list;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if ( i == size - 1){
                        list.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return list;
        }

        // Q8. Check for Symmetrical Binary Trees

        public boolean isSymmetric(TreeNode root) {
            if ( root == null ){
                return true;
            }
            return check(root.left, root.right);
        }
        public boolean check(TreeNode left, TreeNode right){
            if ( left == null || right == null ){
                return left == right;
            }
            if ( left.val != right.val ){
                return false;
            }
            return check(left.left, right.right) && check(left.right, right.left);

        }

        // Q9. Invert Binary Tree

        public TreeNode invertTree(TreeNode root){
            if ( root == null ){
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
        }

        // Q10. Sum Root To Leaf Numbers

        public int findSum(TreeNode root){
            return helper(root, 0);
        }

        public int helper(TreeNode node, int sum ){
            if ( node == null ){
                return 0;
            }
            sum = 10 * sum + node.val;

            if ( node.left == null && node.right == null){
                return sum;
            }
            return helper(node.left, sum) + helper(node.right, sum);
        }

        // Q11. Root to Node Path in Binary Tree

        public ArrayList<Integer> findpath(TreeNode root, int target) {
            ArrayList<Integer> list = new ArrayList<>();
            if ( helper(root, target, list)){
                return list;
        }
            return new ArrayList<>();
        }
        public boolean helper(TreeNode root, int target, ArrayList<Integer> list) {
            if (root == null) {
                return false;
            }
            list.add(root.val);
            if (root.val == target) {
                return true;
            }
            if (helper(root.left, target, list) || helper(root.right, target, list)) {
                return true;
            }
            list.remove(list.size() - 1);
            return false;
        }

        // Q12. LCA - Lowest Common Ancestor

        public TreeNode LCA(TreeNode root, TreeNode x, TreeNode y){

            if ( root == null || root == x || root == y){
                return root;
            }
            TreeNode left = LCA(root.left, x, y);
            TreeNode right = LCA(root.right, x, y);

            // *Important Line of The Code
            if ( left == null ){
                return right; // In the end when coming back either left or right will be null
            } else if  ( right == null ){
                return left; // In the end when coming back either left or right will be null
            }
            else { // If both left and right are null root will be our answer
                return root;
            }
        }

        // Q13. Path Sum

        public boolean hasPathSum(TreeNode root, int targetSum){
            if ( root == null ){
                return false;
            }
            if ( root.val == targetSum && root.left == null && root.right == null ){
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }

        // Q14. Return Path of The Target Sum // Root to Leaf

        public ArrayList<Integer> pathSum(TreeNode root, int targetSum){
            ArrayList<Integer> list = new ArrayList<>();
            if ( helpersum(root, targetSum, list)){
                return list;
            }
            return new ArrayList<>();
        }

        public boolean helpersum(TreeNode root, int targetSum, ArrayList<Integer> list){
            if ( root == null ){
                return false;
            }
            list.add(root.val);
            if ( targetSum - root.val == 0 && root.left == null && root.right == null){
                return true;
            }
            if ( helpersum(root.left, targetSum - root.val, list) || helpersum(root.right, targetSum - root.val, list)){
                return true;
            }
            list.remove(list.size() - 1);
                return false;
        }

        // Q15. Maximum Path Sum

        int maxi = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root){
            maxSumHelp(root);
            return maxi;
        }
        public int maxSumHelp(TreeNode node){
            if ( node == null){
                return 0;
            }
            int left = maxSumHelp(node.left);
            int right = maxSumHelp(node.right);

            left = Math.max(0, left);
            right = Math.max(0, right);

            int sum = left + right + node.val;

            maxi = Math.max(sum, maxi);

            return Math.max(left, right) + node.val;
        }

        // Q16. Root to Node Given Path Exist or Not

        public boolean pathExist(TreeNode root, int[] arr){
            if ( root == null || arr.length == 0){
                return false;
            } return existHelp(root, arr, 0);
        }
        public boolean existHelp(TreeNode node, int[] arr, int index){
            if ( node == null ){
                return false;
            }
            if ( index >= arr.length || node.val != arr[index]){
                return false;
            }
            if (node.left == null && node.right == null && index == arr.length - 1 ){
                return true;
            }
            return existHelp(node.left, arr, index + 1) || existHelp(node.right, arr, index + 1);
        }

        // Q17. Check it two trees are Identical or Not

        public boolean areIdentical(TreeNode root1, TreeNode root2){
            if ( root1 ==  null && root2 == null ){
                return false;
            }
            if ( root1 == null || root2 == null ){
                return false;
            }
            if ( root1.val != root2.val ){
                return false;
            }
            return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
        }

        // Q18, Boundary Traversal in Binary Tree

        public ArrayList<Integer> boundryTraversal(TreeNode root){
            ArrayList<Integer> list = new ArrayList<>();
            if ( root == null ){
                return list;
            }
            if ( !isLeaf(root) ){
                list.add( root.val );
                addleft(root.left, list);
                addLeaf(root, list);
                addRight(root.right, list);
            }
            return list;
        }

        boolean isLeaf(TreeNode node){
            return ( node != null && node.left == null && node.right == null );
        }

        public void addleft(TreeNode root, ArrayList<Integer> list){
            TreeNode cur = root;
            while ( cur != null ){
                if ( !isLeaf(cur) ){
                    list.add(cur.val);
                }
                if ( cur.left != null ){
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        public void addLeaf(TreeNode root, ArrayList<Integer> list){
            if ( root == null ){
                return;
            }
            if ( isLeaf(root)){
                list.add(root.val);
            }
            addLeaf(root.left, list);
            addLeaf(root.right, list);
        }

        public void addRight(TreeNode root, ArrayList<Integer> list){
            TreeNode cur = root;
            ArrayList<Integer> temp = new ArrayList<>();
            while ( cur != null ){
                if ( !isLeaf(cur)){
                    temp.add(cur.val);
                }
                if ( cur.right != null ){
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            for (int i = temp.size() - 1; i >= 0 ; i--) {
                list.add(temp.get(i));
            }
        }
    }


    public static void main(String[] args) {

        Binary_Tree_Questions tree = new Binary_Tree_Questions();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


//        System.out.println(root.maxDepth(root));
//        System.out.println(root.isBalanced(root));
//        System.out.println(root.diameter(root));
//        System.out.println(root.successor(root, 2));
//        System.out.println(root.rsv(root));
//        System.out.println(root.isSymmetric(root));
//        System.out.println(root.findSum(root));
//        System.out.println(root.findpath(root, 5));
//        System.out.println(root.hasPathSum(root, 9));
//        System.out.println(root.pathSum(root, 9));
//        System.out.println(root.maxPathSum(root));
        System.out.println(root.boundryTraversal(root));
    }
}
