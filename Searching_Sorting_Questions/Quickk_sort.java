import java.util.Arrays;

public class Quickk_sort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums, int l, int h) {
        if ( l >= h ){
            return;
        }
        int s = l;
        int e = h;
        int m = s + (e-s)/2;
        int pivot = nums[m];

        while ( s <= e){
            while ( nums[s] < pivot ){
                s++;
            }
            while ( nums[e] > pivot ){
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
        quickSort(nums, l, e);
        quickSort(nums, s, h);
    }
}
