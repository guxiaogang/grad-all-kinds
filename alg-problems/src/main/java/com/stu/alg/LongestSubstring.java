package com.stu.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gut on 10/16/18.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}
