package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TwoPointers {

    //================ 8 Easy ===============

    /**
     * Problem 1
     * LeetCode 455. Assign Cookies
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie.
     *
     * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will
     * be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie
     * j to the child i, and the child i will be content. Your goal is to maximize the number
     * of your content children and output the maximum number.
     *
     * Example 1:
     *
     * Input: g = [1,2,3], s = [1,1]
     * Output: 1
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     *
     * Input: g = [1,2], s = [1,2,3]
     * Output: 2
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     */
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int childIndex = 0;
        int cookieIndex = 0;
        int gLimit = g.length;
        int sLimit = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        while(childIndex < gLimit && cookieIndex < sLimit){
            if(s[cookieIndex] >= g[childIndex]){
                count++;
                childIndex++;
            }
            cookieIndex++;
        }

        return count;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Problem 2
     * LeetCode 234. Palindrome Linked List
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            if(!Objects.equals(list.get(left), list.get(right))) return false;
            left++;
            right--;
        }

        return true;
    }

    /**
     * Problem 3
     * LeetCode 3884. First Matching Character From Both Ends
     * You are given a string s of length n consisting of lowercase English letters.
     *
     * Return the smallest index i such that s[i] == s[n - i - 1].
     *
     * If no such index exists, return -1.
     *
     * Example 1:
     *
     * Input: s = "abcacbd"
     *
     * Output: 1
     *
     * Explanation:
     *
     * At index i = 1, s[1] and s[5] are both 'b'.
     *
     * No smaller index satisfies the condition, so the answer is 1.
     *
     * Example 2:
     *
     * Input: s = "abc"
     *
     * Output: 1
     *
     * Explanation:
     *
     * At index i = 1, the two compared positions coincide, so both characters are 'b'.
     *
     * No smaller index satisfies the condition, so the answer is 1.
     */
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int left = 0;

        for(int i = left; i < n; i++){
            int right = n - i - 1;
            if(s.charAt(left) == s.charAt(right)){
                return left;
            }
            else{
                left++;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        TwoPointers tp = new TwoPointers();
        System.out.println(tp.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(tp.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

}