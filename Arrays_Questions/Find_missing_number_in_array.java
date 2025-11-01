public class Find_missing_number_in_array {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5};
        int n = 5;
        System.out.println(missing(arr, n));

    }

    static int missing(int[] arr, int n) {

        int totalSum = n * ( n + 1 )/2;

        int arrSum = 0;
        for (int i = 0; i < arr.length ; i++) {
            arrSum += arr[i];
        }

        return (totalSum - arrSum);
    }

}
