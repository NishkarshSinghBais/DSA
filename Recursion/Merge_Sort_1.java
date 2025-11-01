import java.util.Arrays;

public class Merge_Sort_1{

    public static void main(String[] args) {

        int[] arr = { 4, 6, 1, 9, 3, 7};
        arr = mergeSort(arr); // Sorted Array, Original is Not Changed.
        System.out.println(Arrays.toString(arr));

        }

        static int[] mergeSort(int[] arr){

            if ( arr.length == 1 ){
                return arr;
            }

            int mid = arr.length / 2;

            int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
            int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

            return merge(arr1, arr2);

        }

        static int[] merge(int[] arr1, int[] arr2){

            int[] mix = new int[ arr1.length + arr2.length ];

            int i = 0;
            int j = 0;
            int k = 0;

            while ( i < arr1.length && j < arr2.length ){
                if ( arr1[i] < arr2[j] ){
                    mix[k] = arr1[i];
                    i++;
                } else {
                    mix[k] = arr2[j];
                    j++;
                }
                k++;
            }

            // May be one of the array is not completed so add remaining elements

            while ( i < arr1.length ){
                mix[k] = arr1[i];
                i++;
                k++;
            }

            while ( j < arr2.length ){
                mix[k] = arr2[j];
                j++;
                k++;
            }

            return mix;
}

}