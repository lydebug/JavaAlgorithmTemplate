package algorithm.slidWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/22 10:03
 * @Description:
 */
public class Leetcode438 {
    public static void main(String[] args) {
        String s1="ab";
        String s2= "abab";
        Leetcode438 A =new Leetcode438();
        System.out.println(A.findAnagrams(s2,s1));
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(p==null||s==null){
            return null;
        }else{
            List<Integer> list = new ArrayList<>();
            int[] set = new int[26];
            Arrays.fill(set,0);
            for(int i=0;i<p.length();i++){
                set[p.charAt(i)-'a']++;
            }
            int r=0,l=0,sz=p.length(),n=s.length();
            while(r<n){
                char c = s.charAt(r);
                if(set[c-'a']>0){
                    while(r-l+1>sz){
                        l++;
                    }
                    if(r-l+1==sz){
                        if(isValid(set,l,r,s)){
                            list.add(l);
                        }
                        l++;
                    }
                }else{
                    l=r;
                }
                r++;
            }
            return list;
        }
    }
    public boolean isValid(int[] nums,int l,int r,String s) {
        int[] ans = new int[26];
        Arrays.fill(ans,0);
        for(int i=l;i<=r;i++){
            ans[s.charAt(i)-'a']++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=ans[i]){
                return false;
            }
        }
        return true;
    }
}
