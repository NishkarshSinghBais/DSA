public class Maximum_sum_of_SubArray_of_K_length {

    public static void main(String[] args){

        int[] arr = { 2, 5, 3, 1, 7, 4, 9, 2, 5, 4 };
        int k = 3;
        System.out.println(slide(arr, k));

    }

    static int slide(int[] arr, int k){

        if ( arr.length < k || k <= 0 ){
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];

            maxSum = Math.max(sum, maxSum);

        }

        return maxSum;
    }
}
