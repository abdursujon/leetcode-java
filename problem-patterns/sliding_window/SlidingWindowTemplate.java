package sliding_window;

import java.util.HashSet;

/**
 * Sliding Window: a contiguous range [left, right] that expands and contracts. // ?
 *
 * 1. findMaxSumOfFixedWindow(int[], int)           - fixed size k; right adds, left removes, window size never changes
 * 2. findLongestSubstringWithoutRepeat(String)     - variable size; grow right always, shrink left only on violation, track the MAX valid window
 * 3. findMinLengthSubarrayAtLeastTarget(int[], int)- variable size; grow right always, shrink left while still valid, track the MIN valid window
 */
public class SlidingWindowTemplate {

    // 1. findMaxSumOfFixedWindow(int[], int) — window size stays k; each step add nums[right], and once the window is full subtract nums[left] and advance left
    public static int findMaxSumOfFixedWindow(int[] nums, int windowSize){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE; // ?
        System.out.println(maxSum);
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];
            if(right - left + 1 == windowSize){
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }


    // 2. findLongestSubstringWithoutRepeat(String) —
    // grow right every step; while the new char breaks the "no repeat" rule, shrink from left; record the window size after it becomes valid
    public static int findLongestSubstringWithoutRepeat(String s){
        HashSet<Character> charsWindow = new HashSet<>();
        int left = 0;
        int longestLength = 0;
        for(int right = 0; right < s.length(); right++){
            while(charsWindow.contains(s.charAt(right))){
                charsWindow.remove(s.charAt(left));
                left++;
            }
            charsWindow.add(s.charAt(right));
            longestLength = Math.max(longestLength, right - left + 1);
        }
        return longestLength;
    }


    // 3. findMinLengthSubarrayAtLeastTarget(int[], int)
    // grow right every step; while the window already satisfies the rule, record its size then shrink from left to look for a smaller one
    public static int findMinLengthSubarrayAtLeastTarget(int[] nums, int target){
        int currentSum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];
            while(currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args){
        System.out.println(findMaxSumOfFixedWindow(new int[] {80, 11, 22, 11, 22, 88, 21, 33, 0}, 2));
        System.out.println(findLongestSubstringWithoutRepeat("ABCABCABCABCD"));
        System.out.println(findMinLengthSubarrayAtLeastTarget(new int[] {80, 11, 22, 11, 22, 88, 21, 33, 0}, 90));
    }

}
