package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Sliding Window: a contiguous range [left, right] that expands and shrinks.
 *
 * 1. findMaxSumOfFixedWindow: fixed size k; right adds, left removes, window size never changes
 * 2. findLongestSubstringWithoutRepeat: variable size; grow right always, shrink left only on violation, track the MAX valid window
 * 3. findMinLengthSubarrayAtLeastTarget: variable size; grow right always, shrink left while still valid, track the MIN valid window
 */
public class SlidingWindowTemplate {

    public static int findMaxSumOfFixedWindow(int[] nums, int windowSize){
        if(nums.length < windowSize) return 0;

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
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


    public static int findLongestSubstringWhileOneRepeatationAllowed(String s){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longestLength = 0;
        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.get(s.charAt(right)) > 2){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            longestLength = Math.max(longestLength, right - left + 1);
        }
        return longestLength;
    }


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
        // if no target found, because target is too large, or small, minLength still points to max integer value, there fore return 0, otherwise return minLength
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args){
        System.out.println(findMaxSumOfFixedWindow(new int[] {80, 11, 22, 11, 22, 88, 21, 33, 0}, 2));
        System.out.println(findLongestSubstringWithoutRepeat("ABCABCABCABCD"));
        System.out.println( findLongestSubstringWhileOneRepeatationAllowed("ABCABCABCABCD") + "one repeat");
        System.out.println(findMinLengthSubarrayAtLeastTarget(new int[] {80, 11, 22, 11, 22, 88, 21, 33, 0}, 90));
    }

}
