import java.util.ArrayList;

public class ArrrayList_Return {

   public static void main(String[] args) {
    
    int[] arr = {1, 3, 5, 5, 5, 6, 5, 7};
    int target = 5;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> ans = returnList(arr, target, 0, list);
    ArrayList<Integer> ans1 = returnList(arr, target, 0, new ArrayList<>());
    System.out.println(list);
    System.out.println(ans1);

   }

   static ArrayList returnList(int[] arr, int target, int index, ArrayList<Integer> list){

    if ( index == arr.length ){
        return list;
    }

    if ( arr[index] == target ){
        list.add(index);
    }

    return returnList(arr, target, index + 1, list);

   }

    
}
