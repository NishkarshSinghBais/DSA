import java.util.Arrays;

public class Rotate_an_array_by_d_places {

    public static void main(String[] args){

        int[] arr = { 3, 4, 6, 1, 7 };
        int d = 2;
        System.out.println(Arrays.toString(rotate(arr, d)));
    }

    static int[] rotate(int[] arr, int d){

        int n = arr.length;
        d = d % n;
        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[n-d+i] = temp[i];

        }

        return arr;
    }

}
