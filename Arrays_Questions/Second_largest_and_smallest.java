import java.util.Arrays;

public class Second_largest_and_smallest {

    public static void main(String[] args){

        int[] arr = { 3, 5, 7, 1, 8, 2, 9 };
        System.out.println(Arrays.toString(both(arr)));
    }

    static int[] both(int[] arr){

        quickSort(arr, 0, arr.length - 1);
        int a = arr[1];
        int b = arr[arr.length - 2];
        return new int[]{a, b};

    }

    static void quickSort(int [] arr, int l, int h) {

        if ( l < h ) {

            int pivot = partition(arr, l, h);

            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);


        }
    }

    static int partition(int[] arr, int l, int h){

        int pivot = arr[h];
        int j = ( l - 1 );

        for (int i = l; i < h; i++) {
            if ( arr[i] < pivot ){
                j++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }

        int temp = arr[j + 1];
        arr[j + 1] = arr[h];
        arr[h] = temp;

        return j + 1;
    }
}
