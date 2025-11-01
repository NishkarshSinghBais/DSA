import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 1, 4};

        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void selectionSort(int[] nums){
        for (int i=0; i< nums.length; i++){
            int last = nums.length - i - 1; //
            int maxIdx = findMaxIdx(nums, 0, last);
            swap(nums, maxIdx, last);
        }
    }
    static int findMaxIdx(int[] nums, int start, int end){
        int max = start;

        for (int i=start; i<= end; i++){
            if (nums[i] > nums[max]){
                max = i;
            }

        }
        return max;
    }

    static void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }
}
