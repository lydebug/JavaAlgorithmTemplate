package algorithm.slidWindow;

import java.util.HashMap;

/**
 * @Author: liyang27
 * @Date: 2020/7/21 21:22
 * @Description:无重复字符的最长子串
 */
public class Leetcode3 {
    public static void main(String[] args) {
        String s="bbtablud";
        Leetcode3  A =new Leetcode3();
        System.out.println(A.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,right=0,size=s.length(),len=0;
        while(right<size){
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                int idx=map.get(c);
                while(left<=idx){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(c,right);
            }else{
                map.put(c,right);
                len=Math.max(map.size(),len);
            }
            right++;
        }
        return len;
    }
}
