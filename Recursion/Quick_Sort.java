import java.util.Arrays;

public class Quick_Sort {

    public static void main(String[] args) {

        int[] nums = {9, 2, 5, 7, 2, 1, 4, 0};
        quick(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));


        

    }

    static void quick(int[] nums, int low, int high){

        if ( low >= high ){
            return;
        }

        int s = low;
        int e = high;
        int m = s + ( e - s ) / 2;
        int pivot = nums[m];

        while ( s <= e ) {
            while ( nums[s] < pivot ){
                s++;
            }

            while ( nums[e] > pivot ) {
                e--;
                
            }

            if ( s <= e ){
                int temp = nums[s];
             nums[s] = nums[e];
             nums[e] = temp;

                s++;
                e--;

            }
            
        }

        quick (nums, low, e);
        quick (nums, s, high);


    }

    
}