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

    public static void main(String [] args){

        // LeetCode 35. Search Insert Position
        ArrayManipulation ar = new ArrayManipulation();
        System.out.println(ar.searchInsert(new int[]{1, 3, 5, 7}, 9));

    }
}