package algorithm.backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: liyang27
 * @Date: 2020/7/20 18:43
 * @Description:  全排列
 */
public class Leetcode46 {
    List<List<Integer>> res = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new LinkedList<>());
        return res;
    }
    public void backtrack(int[] nums,List<Integer> list){
        if(list.size()==nums.length){
            List<Integer> ans = new LinkedList<>(list);
            res.add(ans);
            return;
        }
        for(int i:nums){
            if(!set.contains(i)){
                list.add(i);
                set.add(i);
                backtrack(nums,list);
                list.remove(Integer.valueOf(i));
                set.remove(i);
            }
        }
    }
}
