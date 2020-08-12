package algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 21:10
 * @Description:组合
 */
public class Leetcode77 {
    public static void main(String[] args) {
        Leetcode77 A = new Leetcode77();
        System.out.println(A.combine(4, 3));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(1, k, n, new ArrayList<>());
        return ans;
    }

    public void combine(int s, int k, int n, List<Integer> list) {
        if (list.size() == k) {
            List<Integer> res = new ArrayList<>(list);
            ans.add(res);
        } else if (s <= n) {
            for (int i = s; i <= n; i++) {
                list.add(i);
                combine(i + 1, k, n, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
