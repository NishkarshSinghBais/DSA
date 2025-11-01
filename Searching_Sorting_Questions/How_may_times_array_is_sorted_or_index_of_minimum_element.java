public class How_may_times_array_is_sorted_or_index_of_minimum_element {

    public static void main(String[] args) {

        int[] arr = { 4, 5, 6, 7, 1, 2, 3 };
        System.out.println(rotate(arr));
    }

    static int rotate(int[] arr){

        int s = 0;
        int e = arr.length - 1;

        while ( s < e ){ // important
            int m = s + ( e - s );
            if ( arr[s] < arr[m] ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return s;
    }
}
