import java.util.Arrays;

public class Merge_sort {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 9, 8};
        int[] ans = mergeSort(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] mergeSort(int[] nums) {
        if ( nums.length == 1 ){
            return nums;
        }

        int m = nums.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(nums, m, nums.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k =  0;

        while ( i < left.length && j < right.length ){
            if ( left[i] < right[j] ){
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        // if any of the array left with some elements, add remaining to mix.
        while ( i < left.length ){
            mix[k] = left[i];
            i++;
            k++;
        }

        while ( j < right.length ){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }
}
