import java.util.*;

public class ArrayManipulation {

    // ================== 7 easy leetcode =================

    /**
     * Problem 1
     * LeetCode 35: Search Insert Position
     * Find the suitable index for target in sorted array.
     * Example: nums = { 1, 3, 5, 7} and target = 9, target position will be 4 (0 index) since 9 is the largest
     * Note: This patterns is two pointer as we use left and right pointer to find the best index for target
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * Problem 2
     * LeetCode 121: Best Time to Buy and Sell Stock
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxPro = Math.max(maxPro, prices[j] - prices[i]);
            }
        }
        return maxPro;
    }


    /**
     * Problem 3
     * LeetCode 283. Move Zeroes
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.

     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }

        int i = 0;
        while (i < list.size()) {
            nums[i] = list.get(i);
            i++;
        }

        for (int j = list.size(); j < nums.length; j++) {
            nums[j] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }


    /**
     * Problem 4
     * LeetCode 169. Majority Element
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i : nums) {
            for (int j : nums) {
                if (i == j) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                return i;
            }
            count = 0;
        }

        return major;
    }


    public int majorityElementAlternativeSolution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Problem 5
     * LeetCode 349. Intersection of Two Arrays
     * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
     * unique and you may return the result in any order.
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> intersectSet = new HashSet<>();
        for (int n : nums1) {
            seen.add(n);
        }

        for (int n : nums2) {
            if (seen.contains(n)) {
                intersectSet.add(n);
            }
        }

        int[] result = new int[intersectSet.size()];
        int i = 0;
        for (int n : intersectSet) {
            result[i++] = n;
        }

        return result;
    }

    /**
     * Problem 6
     * LeetCode 50. Intersection of Two Arrays II
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        int k = 0;
        for (int n : list) {
            ans[k++] = n;
        }

        return ans;
    }


    /**
     * Problem 7:
     * LeetCode 414: Third Maximum Number
     * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
     *
     * Example 1:
     *
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     * Example 2:
     *
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     */
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int n : nums) {
            if (!list.contains(n)) {
                list.add(n);
            }
        }
        Collections.reverse(list);

        if (list.size() == 1) {
            return list.getFirst();
        } else if (list.size() == 2) {
            return Collections.max(list);
        } else {
            return list.get(2);
        }
    }

    // ================== 8 medium =================

    /**
     * Problem 1:
     * LeetCode 15: 3Sum
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> threeSumList = new ArrayList<>();

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    threeSumList.add(List.of(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if( sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }

        return threeSumList;
    }


    /**
     * Problem 2:
     * LeetCode 18: 4Sum
     * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     *
     * The solution is in O(n3)
     */
    public List<List<Integer>> fourSum ( int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Since we need 4 elements and 4 index reference pointer, we do n - 3 so i always stays in array index limit
        for(int i = 0; i < n - 3; i++){

            // if index i = 0 and i = 0 + 1, elements are same item, continue since we need distinct element
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n; j++){

                // same as i, if duplicate found continue
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                // start two pointer so we can track target sum
                int left = j + 1;
                int right = n - 1;

                while(left < right){

                    // cast to long bcs sum limit is higher than int max value
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    // when sum == target, we add it to the ans list, and increment and decrement left and right
                    if(sum == target){
                        ans.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // if in position left or right found a duplicate continue
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    } else if(sum < target){ // when sum < target , our sum is too small and we need bigger number so move left
                        left++;
                    } else { // when sum > target, out sum is too large therefore we move right to get smaller number
                        // remember our array is sorted therefore large element sitting in last indexes
                        right--;
                    }
                }

            }
        }

        return ans;
    }


    /**
     * Problem 3
     * LeetCode 31: Next Permutation
     * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
     *
     * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
     * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
     *
     * For example, the next permutation of arr = [1,2,3] is [1,3,2].
     * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
     * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
     * Given an array of integers nums, find the next permutation of nums.
     *
     * The replacement must be in place and use only constant extra memory.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     *
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     *
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // if for example we have {1, 4, 9} here 4 >= 9 (false) so i-- does not happen
        // if for example we have {3, 11, 2} here 11 >= 2 (true) so i-- happens
        // we do this so we can find the index when left < right for example {2, 4, 9} here 4 < 9
        while(i >= 0 && (nums[i] >= nums[i + 1])){
            i--;
        }

        // when i is pointing to index 0 or greater we might have condition where i < j so we can swap i and j
        if(i >= 0){
            // last element
            int j = n - 1;
            // if last element (j) is less then equal to element before we skip that element
            while(nums[j] <= nums[i]) j--;
            // swap value around
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // i>= 0 failed there for i < 0 for example {3, 2, 1} here i will be i< 0
        int low = i + 1; // i = -1 there for i + 1 = 0
        int high = n - 1;
        while(low < high){
            // swap the first value of num with last value to reverse the array
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        System.out.println(Arrays.toString(nums));
    }


    /**
     * Problem 4
     * LeetCode 33: Search in Rotated Sorted Array
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     */
    public int search(int[] nums, int target) {
        // {4, 5, 6, 7, 0, 1, 2}
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            // if target is mid return mid index
            if(nums[mid] == target) return mid;

            // left halft is sorted
            if(nums[left] <= nums[mid]){
                // here we check if nums[left] is less or equal to target and if target itself is less than mid
                // for example {4, 5, 6, 7, 0, 1, 2} here mid is 7, so if the target is 4 that means 4 < 7
                // since we know target is in left half of the array we discard right half
                if(nums[left] <= target && target < nums[mid]){
                    // mid is > target move to left
                    right = mid - 1;
                } else{
                    // mid is too small, move to right
                    left = mid + 1;
                }
            }

            // right half is sorted
            else{
                // if we have array such as {0, 1, 2, 4, 5, 6, 7} here if target is 6, our mid is 4 < target (6)
                // we move left + 1 until we find the mid which is equal to target
                if(nums[mid] < target && target <= nums[right]){
                    // mid is too small move to the right for larger item
                    left = mid + 1;
                } else{
                    // mid is too large move to left for small item
                    right = mid - 1;
                }
            }
        }
        return -1;
    }



    /**
     * Problem 5
     * LeetCode 34: Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     */
    public int binarySearch(int[] nums, int target, boolean isSearchingLeft){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while(left <= right){
            // if our array is {1, 2, 3, 4, 4, 5, 6, 7} mid = 8 / 2 = 4
            int mid = (left + right) / 2;

            // if target is 2, mid(4) > target(2)
            if(target < nums[mid]){
                // target is on the left side of the mid, so point right to mid - 1 (in this example index 3)
                right = mid - 1;
            } else if(target > nums[mid]){ // target is > nums[mid] for example target(7) > mid(4)
                left = mid + 1; // since we don't need to look to the left side of the mid, we do mid + 1
            } else{
                // if both target < nums[mid] and target > nums[mid] fails that means target is the mid element so index = mid
                index = mid;

                // when we're searching left right should be point to mid - 1 since right side of mid discared
                if(isSearchingLeft){
                    right = mid -1;
                } else{
                    // if not searching left, we are searching right so left should start from mid + 1
                    left = mid + 1;
                }
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target){
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }


    // 6.


    // 7.


    // 8.

    // ================== 2 hard =================

    public static void main(String[] args) {

        ArrayManipulation am = new ArrayManipulation();

        // ================== 7 easy leetcode =================
        // 1. Search Insert Position (LeetCode 35)
        System.out.println(am.searchInsert(new int[]{1, 4, 6, 8, 9}, 2));

        // 2. Best Time to Buy and Sell Stock (leetcode 121)
        am.maxProfit(new int[]{2, 11, 5, 77});

        // 3. Move Zeroes (leetcode 283)
        am.moveZeroes(new int[]{2, 11, 5, 77, 0, 1, 0, 9, 0});

        // 4. Majority Element (leetcode 169)
        System.out.println(am.majorityElement(new int[]{1, 3, 4, 9, 3, 3}));

        // 5. Intersection of two arrays (leetcode 349)
        System.out.println(am.intersection(new int[]{1, 7, 11, 1, 1, 1, 90, 3, 4, 4, 5}, new int[]{1, 7, 11, 1, 1, 1, 90, 3, 4, 4, 5}));

        // 6. Intersection of two arrays ii (leetcode 350)
        System.out.println(am.intersect(new int[]{1, 7, 11, 1, 1, 1, 90, 3, 4, 4, 5}, new int[]{1, 7, 11, 1, 1, 1, 90, 3, 4, 4, 5}));


        // 7. Third Maximum number (leetcode 414)
        System.out.println(am.thirdMax(new int[]{1, 7, 11, 1, 1, 1, 90, 3, 4, 4, 5}));


        // ================== 8 medium =================

        // Problem 1: LeetCode 15: 3Sum
        System.out.println(am.threeSum(new int[]{3, 2, 1, -1, -2}));

        // Problem 2: LeetCode 18: 4Sum
        System.out.println(am.fourSum(new int[]{3, 2, 1, 9, 3, 2, 1, 9}, 15));

        // Problem 3: LeetCode 31: Next Permutation
        am.nextPermutation(new int[]{3, 2, 1});

        // Problem 4: LeetCode 33: Search
        System.out.println(am.search(new int[]{3, 4, 6, 7, 0, 1, 2}, 1));


        // Problem 4: LeetCode 34: SearchRange
        System.out.println(Arrays.toString(am.searchRange(new int[]{5,7,7,8,8,10}, 10)));



        // ================== 2 hard =================
    }
}