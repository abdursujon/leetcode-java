package hashing;

public class HashingTemplate {
    /**
     *   1. Frequency counting — HashMap<element, count>. Anagrams, majority element, first unique char, top-K.
     *   2. Complement lookup (Two Sum) — HashMap<value, index>; check if target - current was seen.
     *   3. Grouping — HashMap<key, List>; group anagrams (key = sorted string), group by any derived key.
     *   4. Membership / uniqueness — HashSet; contains-duplicate, and the Longest Consecutive Sequence trick (only start counting from a
     *   number with no predecessor).
     *   5. Prefix sum + map — HashMap<runningSum, count>, initialized with {0: 1}; count subarrays summing to k.
     *   6. Sliding window + map — window pointers + a HashMap tracking the window's char counts / last-seen index.
     */
}
