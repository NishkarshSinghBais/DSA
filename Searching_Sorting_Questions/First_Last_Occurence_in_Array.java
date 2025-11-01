public class First_Last_Occurence_in_Array {

    public static void main(String[] args) {

        int[] arr = {3,4,13,13,13,20,40};
        System.out.println(binarySearch(arr, 13));

    }

    static int binarySearch(int[] arr, int target){

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + ( e - s )/2;
            if ( arr[m] == target ){
                ans = m;
                e = m - 1; // Single Change s = m + 1 ( for last occurence )
            } else if ( arr[m] > target ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}
