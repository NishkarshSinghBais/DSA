public class Count_occurences_of_a_number {

    public static void main(String[] args){

        int[] arr = { 2, 4, 5, 5, 5, 6, 8, 9, 9 };
        System.out.println(occurences(arr, 9));

    }

    static int occurences(int[] arr, int target){


        int first = First_occur(arr, target);
        int second = Last_occur(arr, target);

        if ( first == -1 || second == -1 ){
            return 0;
        }

        return second - first + 1;
    }

    static int First_occur(int[] arr, int target){

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + ( e - s ) / 2;
            if ( arr[m] == target ) {
                ans = m;
                e = m - 1;
            } else if ( arr[m] > target ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }

    static int Last_occur(int[] arr, int target){

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + ( e - s ) / 2;
            if ( arr[m] == target ) {
                ans = m;
                s = m + 1;
            } else if ( arr[m] > target ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }
}
