// Lower bound : smallest index greater than equal to taregt

public class Lower_bound {

    public static void main(String[] args) {

        int[] arr = { 0, 3, 5, 7, 9 };
        System.out.println(loweBound(arr, 1, arr.length));

    }

    static int loweBound(int[] arr, int target, int n){

        int s = 0;
        int e = n - 1;

        int ans = n;

        while ( s <= e ){
            int m = s + ( e - s ) / 2;

            if ( arr[m] >= target ){
                ans = m;

                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }
}
