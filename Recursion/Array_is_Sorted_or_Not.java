public class Array_is_Sorted_or_Not {

    public static void main(String[] args) {
     
    int[] arr = {1, 4, 6, 9};
    System.out.println(isSorted(arr, 0));

    }

    static boolean isSorted(int[] arr, int index){
        if ( index == arr.length - 1){
            return true;
        }

        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }
    
}
