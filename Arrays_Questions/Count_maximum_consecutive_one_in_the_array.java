public class Count_maximum_consecutive_one_in_the_array {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1, 0, 3, 1, 1, 1, 1};
        System.out.println(count(arr));

    }

    static int count(int[] arr){

        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] == 1 ){
                count++;
            } else {
                count = 0;
            }

            maxCount = Math.max(maxCount, count);

            }

        return maxCount;
        }
}
