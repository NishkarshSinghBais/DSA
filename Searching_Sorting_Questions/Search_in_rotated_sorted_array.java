public class Search_in_rotated_sorted_array {

    public static void main(String[] args) {

        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        System.out.println(rotated(arr, 1));

    }

    static int rotated(int[] arr, int target){

        int s = 0;
        int e = arr.length - 1;

        while ( s <= e ){
            int m = s + ( e - s ) / 2;
            if ( arr[m] == target ){
                return m;
            }

            // if left part is sorted
            if ( arr[s] <= arr[m] ){
                if ( arr[s] <= target && target <= arr[m]){
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
            // if right part is sorted
            else {
                if ( arr[e] >= target && target >= arr[m] ){
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return -1;
    }
}
