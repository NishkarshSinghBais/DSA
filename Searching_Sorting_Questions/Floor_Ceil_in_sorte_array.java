// Ceil = Smallest element greater than equal to target
// Floor = Largest element smaller than equal to target

import java.util.Arrays;

public class Floor_Ceil_in_sorte_array {

    public static void main(String[] args) {

        int[] arr = { 2, 4, 6, 8, 9, 10 };
        System.out.println(Arrays.toString(floorCeil(arr, 7, arr.length)));
    }

    static int[] floorCeil(int[] arr, int target, int n ){

        int a = floor(arr, target, n);
        int b = ceil(arr, target, n);
        return new int[]{a, b};
    }

    static int floor(int[] arr, int target, int n){

        int s = 0;
        int e = n - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + ( e - s )/2;
            if ( arr[m] <= target ){
                ans = arr[m];
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return ans;
    }

    static int ceil(int[] arr, int target, int n){

        int s = 0;
        int e = n - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + ( e - s )/ 2;
            if ( arr[m] >= target ){
                ans = arr[m];

                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}
