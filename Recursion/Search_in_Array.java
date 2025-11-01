public class Search_in_Array {

    public static void main(String[] args) {
        
        int[] arr = {2, 5, 7, 9};
        int target = 7;
        int ans = search(arr, target, 0);
        System.out.println(ans);

    }

    static int search(int[] arr, int target, int index){

        if ( index == arr.length ){
            return -1;
        }

        if ( arr[index] == target ){
            return index;
        }

        else {
            return search(arr, target, index + 1);
        }
    }
}
