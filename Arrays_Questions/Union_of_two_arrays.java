import java.util.ArrayList;

public class Union_of_two_arrays {

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 3, 4 };
        int[] arr2 = { 1, 1, 3, 5, 5, 6 };

        System.out.println(union(arr1, arr2));

    }

    static ArrayList<Integer> union(int[] arr1, int[] arr2){

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        int n1 = arr1.length;
        int n2 = arr2.length;

        while ( i < n1 && j < n2 ) {
            if (arr1[i] <= arr2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if ( arr1[i] > arr2[j] ){
                    if (list.isEmpty() || list.get(list.size() - 1) != arr2[j]){
                        list.add(arr2[j]);
                    }
                    j++;
                }
        }

            }

        while ( i < n1 ){
            if ( list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }

        while ( j < n2 ){
            if ( list.isEmpty() || list.get(list.size() - 1) != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }

        return list;

        }
}
