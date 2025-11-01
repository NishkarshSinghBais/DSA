package Linked_List;

public class Main_CLL {
    public static void main(String[] args) {

        CLL list = new CLL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.delete(3);

        list.display();
    }
}
