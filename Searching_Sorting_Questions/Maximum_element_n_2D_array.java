public class Maximum_element_n_2D_array {

        public static void main(String[] args) {
            int[][] arr = {{1, 2, 3},
                    {5, 88, 7},
                    {9, 10, 6}};
            int ans = binSearch(arr);
            System.out.println((ans));

        }

        static int binSearch(int[][] arr) {

            int maxElement = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if ( arr[i][j] > maxElement ){
                        maxElement = arr[i][j];
                    }
                }
            }
            return maxElement;
        }
}
