package algorithm.slidWindow;

import algorithm.backtrack.Leetcode51;

import java.util.*;

/**
 * @Author: liyang27
 * @Date: 2020/7/22 09:28
 * @Description:
 */
public class Leetcode567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Leetcode567 A = new Leetcode567();
        System.out.println(A.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null) {
            return true;
        } else if (s2 == null) {
            return false;
        } else {
            int[] set = new int[26];
            Arrays.fill(set, 0);
            for (int i = 0; i < s1.length(); i++) {
                set[s1.charAt(i) - 'a']++;
            }
            int r = 0, l = 0, sz = s1.length(), n = s2.length();
            while (r < n) {
                char c = s2.charAt(r);
                if (set[c - 'a'] > 0) {
                    while (r - l + 1 > sz) {
                        l++;
                    }
                    if (r - l + 1 == sz) {
                        if (isValid(set, l, r, s2)) {
                            return true;
                        } else {
                            l++;
                        }
                    }
                } else {
                    l = r;
                }
                r++;
            }
            return false;
        }
    }

    public boolean isValid(int[] nums, int l, int r, String s) {
        int[] ans = new int[26];
        Arrays.fill(ans, 0);
        for (int i = l; i <= r; i++) {
            ans[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
