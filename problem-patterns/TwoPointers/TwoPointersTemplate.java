package TwoPointers;

import java.util.Arrays;

/**
 * Two Pointers pattern template — opposite ends converging inward.
 *
 * 1. findPairWithTargetSumSorted(int[], int) - comparison to a target decides which pointer moves; only one moves per step (sorted input)
 * 2. reverseArrayInPlace(int[])              - no condition; always swap and always move both pointers until they meet
 * 3. isPalindrome(String)                    - compare both ends, both move every step, early-exit on mismatch; read-only check
 */
public class TwoPointersTemplate {

    // 1. findPairWithTargetSumSorted(int[], int) — only one pointer moves per step, chosen by comparing currentSum to targetSum
    public int[] findPairWithTargetSumSorted(int[] nums, int targetSum){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int currentSum = nums[left] + nums[right];
            if(currentSum == targetSum){
                return new int[] {left, right};
            } else if(currentSum < targetSum){
                left++;
            } else{
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // 2. reverseArrayInPlace(int[]) — no condition decides movement; swap and move both pointers every step until they meet
    public static int[] reverseArrayInPlace(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    // 3. isPalindrome(String) - compare both ends, both move every step, early-exit on mismatch; read-only, no writes
    public boolean isPalindrome(String s) {
        int left= 0;
        int right= s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(reverseArrayInPlace(new int[]{1, 2, 3, 4, 5})));
    }

}