import java.util.*;

class aa_PRACTICE{

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12, 0};
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if(nums[r] == 0){
                r--;
            }
            if ( nums[l] == 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}