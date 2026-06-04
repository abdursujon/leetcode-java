package TwoPointers;

import java.util.Arrays;

public class TwoPointers {

    //================ 8 Easy ===============

    // Problem 1: LeetCode 455. Assign Cookies
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

    public static void main(String[] args){
        TwoPointers tp = new TwoPointers();
        System.out.println(tp.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(tp.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

}