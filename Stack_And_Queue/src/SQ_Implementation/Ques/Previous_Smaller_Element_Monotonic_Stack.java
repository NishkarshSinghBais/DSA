package SQ_Implementation.Ques;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Smaller_Element_Monotonic_Stack {

    public static void main(String[] args) {

        int[] arr = {5, 7, 9, 6, 7, 4};
        System.out.println(Arrays.toString(nge(arr)));

    }
    static int[] nge(int[] arr){

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while ( !st.isEmpty() && st.peek() >= arr[i] ){
                st.pop();
            }
            if ( st.isEmpty() ){
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
