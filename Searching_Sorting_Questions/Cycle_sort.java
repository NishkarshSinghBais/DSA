import java.util.Arrays;

public class Cycle_sort {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static  void cycleSort(int[] nums){
        int i = 0;
        while ( i < nums.length ){
            int correct = nums[i] - 1;
            if ( nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
    }
}
