import java.util.Arrays;

public class Left_rotate_an_array_by_one_place {

    public static void main(String[] args){

        int[] arr = { 2, 4, 6, 7, 9, 1, 4 };
        System.out.println(Arrays.toString(rotate(arr)));

    }

    static int[] rotate(int[] arr){

        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];

        }

        arr[arr.length - 1] = temp;

        return arr;

    }
}
