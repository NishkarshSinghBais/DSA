import java.util.ArrayList;
import java.util.Arrays;

public class Move_all_zeroes_to_the_end_of_the_array {

    public static void main(String[] args) {

        int[] arr = { 0, 3, 0, 0, 4, 0, 7};
        System.out.println(Arrays.toString(zeroes(arr)));

    }

    static int[] zeroes(int[] arr){

        int j = -1;

        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] == 0 ){
                 j = i;
                 break;
            }

        }

        for (int i = j; i < arr.length; i++) {
            if ( arr[i] != 0 ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }

        }

        return arr;
    }
}