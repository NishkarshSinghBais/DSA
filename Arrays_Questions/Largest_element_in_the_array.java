public class Largest_element_in_the_array {

    public static void main(String[] args) {

        int[] arr = { 3, 6, 1, 8, 2, 9, 3, 5, 2 };
        System.out.println(largest(arr));
    }

    static int largest(int[] arr){

        int largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] > largest ){
                int temp = arr[i];
                arr[i] = largest;
                largest = temp;
            }
        }

        return largest;
    }

}
