import java.util.Arrays;

public class Bubble_sort {
    public static void main(String[] args) {

        int[] nums = {5, 3, 2, 1, 4};

        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void bubbleSort(int[] nums){

        for (int i=0; i< nums.length; i++) { // controls the number of passes
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }
    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
