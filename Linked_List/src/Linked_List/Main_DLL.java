package Linked_List;

public class Main_DLL {
    public static void main(String[] args) {

        DLL list = new DLL();

        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(4);



        list.display();
        list.duplicateremove();
        list.display();
    }
}
