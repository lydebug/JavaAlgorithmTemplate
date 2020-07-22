package algorithm.slidWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liyang27
 * @Date: 2020/7/21 21:56
 * @Description:最小覆盖子串
 */
public class Leetcode76 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        Leetcode76 A = new Leetcode76();
        System.out.println(A.minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int l = 0, r = 0, len = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c,0);
            if (mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) + 1);
            } else {
                mapT.put(c, 1);
            }
        }
        while (r < s.length()) {
            Character c = s.charAt(r);
            if (mapT.containsKey(c)) {
                if (map.isEmpty()) {
                    l = r;
                }
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }
                if (isValid(mapT, map)) {
                    //changeLeft
                    Character c2;
                    while (l <= r && isValid(mapT, map)) {
                        c2 = s.charAt(l);
                        if(map.containsKey(c2)){
                            map.put(c2,map.get(c2)-1);
                        }
                        l++;
                    }
                    int start=l-1;
                    if (r - start + 1 < len) {
                        len = r - start + 1;
                        res = s.substring(start, r + 1);
                    }

                }
            }
            r++;
        }
        return res;
    }

    public boolean isValid(Map<Character, Integer> A, Map<Character, Integer> B) {
        for (Character c : A.keySet()) {
            if (A.get(c)>(B.get(c))) {
                return false;
            }
        }
        return true;
    }
}
