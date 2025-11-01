public class Row_with_maximum_number_of_1s_or_ones {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1},
                       {1, 0, 0},
                       {0, 0, 1}};
        System.out.println(maximum(arr));

    }

    static int maximum(int[][] arr) {

        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1 ){
                    count++;
                }
            }
            if ( count > maxCount ){
                maxCount = count;
                index = i;
            }
        }
        return index;
    }
}
