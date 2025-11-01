public class Array_is_sorted_or_not {

    public static void main(String[] args){

        int[] arr = { 2, 4, 6, 8, };
        System.out.print("Array is sorted : " + check(arr));
    }

    static boolean check(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            if ( arr[i] > arr[i + 1] ){
                return false;
            }
        }

        return true;
    }
}
