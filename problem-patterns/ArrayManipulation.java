public class ArrayManipulation{

    /** LeetCode 35. Search Insert Position
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


    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxPro = Math.max(maxPro, prices[j] - prices[i]);
            }
        }
        return maxPro;
    }


    // 283. Move Zeroes
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


    // 169. Majority Element
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


    // 349. Intersection of two arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> intersectSet = new HashSet<>();
        for(int n: nums1){
            seen.add(n);
        }

        for(int n: nums2){
            if(seen.contains(n)){
                intersectSet.add(n);
            }
        }

        int[] result = new int[intersectSet.size()];
        int i = 0;
        for(int n: intersectSet){
            result[i++] = n;
        }

        return result;
    }


    // 350. Intersection of two arrays ii
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int i = 0; int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        int k = 0;
        for(int n: list){
            ans[k++] = n;
        }

        return ans;
    }


    // 414. Third Maximum number
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int n: nums){
            if(!list.contains(n)){
                list.add(n);
            }
        }
        Collections.reverse(list);

        if(list.size() == 1){
            return list.getFirst();
        } else if(list.size() == 2){
            return Collections.max(list);
        } else {
            return list.get(2);
        }
    }

    public static void main(String [] args){

        ArrayManipulation ar = new ArrayManipulation();

        // 35. Search Insert Position
        System.out.println(ar.searchInsert(new int[]{1, 3, 5, 7}, 9));

        // 121. Best Time to Buy and Sell Stock

        // 283. Move Zeroes

        // 169. Majority Element

        // 349. Intersection of two arrays

        // 350. Intersection of two arrays ii

        // 414. Third Maximum number
    }
}