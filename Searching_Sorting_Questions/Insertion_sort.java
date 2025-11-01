import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 1, 4, 9, 6, 7};

        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void insertionSort(int[] nums){
        for (int i=0; i<nums.length-1; i++){ // till second last index
            for (int j=i+1; j>0; j--){
                if (nums[j] < nums[j-1]){
                    swap(nums, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swap(int[] nums,  int f, int s){
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
