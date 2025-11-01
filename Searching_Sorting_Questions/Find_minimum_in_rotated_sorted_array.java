public class Find_minimum_in_rotated_sorted_array {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 3 };
        System.out.println(minimum(arr));
    }

    static int minimum(int[] arr){

        int s = 0;
        int e = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while ( s <= e ){
            int m = s + ( e - s ) / 2;
            // if array is like { 1, 2, 3, 4, 5 }; Not Rotated Sorted
            if ( arr[s] <= arr[e] ){
                ans = Math.min(ans, arr[s]);
                break;
            }
            if ( arr[s] <= arr[m] ){
                ans = Math.min(ans, arr[s]);
                s = m + 1;
            } else {
                ans = Math.min(ans, arr[m]);
                e = m - 1;
            }
        }
        return ans;
    }
}
