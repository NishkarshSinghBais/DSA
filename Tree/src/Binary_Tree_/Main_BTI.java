package Binary_Tree_;

public class Main_BTI {
    public static void main(String[] args) {

        BinaryTree_Implementation tree = new BinaryTree_Implementation();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);


        tree.preorder();
    }
}
