package SQ_Implementation.Ques;

import java.util.ArrayList;

public class Aestroid_Collisions_Using_List {
    public static void main(String[] args) {

        int[] arr = { 4, 7, 1, 1, 2, -3, -7, 17, 15, 16 };
        System.out.println(find(arr));

    }

    static ArrayList<Integer> find(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if ( current > 0 ){
                list.add(current);
            } else {
                while ( !list.isEmpty() && list.get(list.size() - 1) > 0){
                    int top = list.get(list.size() - 1);
                    if ( top > Math.abs(current)){
                        break;
                    }
                    if ( top == Math.abs(current)){
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        list.remove(list.size() - 1); // if top < absolute value of current
                    }
                }
                if ( list.isEmpty() || list.get(list.size() - 1) < 0){
                    list.add(current);
                }
            }
        }
        return list;
    }
}