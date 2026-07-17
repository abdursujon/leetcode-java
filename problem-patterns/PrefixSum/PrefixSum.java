package PrefixSum;

import java.util.*;

public class PrefixSum {
    public int subarraySumToTarget(int[] nums, int target){
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for(int n: nums){
            currentSum += n;

            int targetSum = currentSum - target;
            if(prefixSumCount.containsKey(targetSum)){
                count += prefixSumCount.get(targetSum);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
