package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashingTemplate {

    // Pattern 1: Majority counting
    public static int findMajorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // go through all keyset of map then find the item is the majority
        for(int n: map.keySet()){
            if(map.get(n) > nums.length / 2){
                return n;
            }
        }
        return -1;
    }


    // Pattern 2: Find first unique character index
    public static int firstUniqueCharacter(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }


    // Pattern 3: Complement look up (Two Sum) , find the index of two elements that add up to target
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Pattern 4: Grouping, take array of strings and group similar element together (for example anagram)
    public static List<List<String>> groupSimilarElements(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            map.putIfAbsent(sorted, new ArrayList<>());
            // adds s into the arraylist
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Pattern 5: Membership and check if duplicate
    public static boolean isDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }

    // Pattern 6: Longest consecutive sequence
    public static int longestConsecutive(int[] nums){
        // converts the nums array to first stream of int, then boxed into Integer object, then make that integer array list to list, then that list is turn into Hashset
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        int maxLen = 0;
        for(int n: set){
            if(!set.contains(n - 1)){
                int currentNum = n;
                int currentLen = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(findMajorityElement(new int[] {1, 9, 2, 343, 4, 9, 4, 4, 2, 3, 4, 4, 4, 4, 4, 4, 4})); // 4

        System.out.println(firstUniqueCharacter("ABC")); // 0
        System.out.println(firstUniqueCharacter("ABCabcD")); // 0
        System.out.println(firstUniqueCharacter("ABCABCD")); // 6

        System.out.println(Arrays.toString(twoSum(new int[]{2, 89, 2, 5, 3, 0, 4}, 4))); // [0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 89, 2, 5, 3, 0, 4}, 99))); // [] nothing adds up to 99

        System.out.println(groupSimilarElements(new String[]{"eat", "tea", "mum", "tan", "ant", "bat", "ate"}));

        System.out.println(longestConsecutive(new int[]{1, 6, 7, 88, 2, 3, 4, 5, 0, 100, 290}));
        System.out.println(longestConsecutive(new int[]{88, 88, 88, 88 }));
    }
}
