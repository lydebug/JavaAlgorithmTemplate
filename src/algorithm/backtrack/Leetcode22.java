package algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 20:24
 * @Description:括号生成 左边的括号数目==右边的括号数目
 * 左边的括号数目+右边的括号数目等于2n
 * 左边的括号数目始终大于等于右边的括号数目
 */
public class Leetcode22 {
    public static void main(String[] args) {
        Leetcode22 A = new Leetcode22();
        System.out.println(A.generateParenthesis(3));
    }

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n > 0) {
            Map<String, Integer> map = new HashMap<>();
            map.put("(", 0);
            map.put(")", 0);
            List<String> list = new ArrayList<>();
            generate(map, n, list);
        }
        return ans;
    }

    public void generate(Map<String, Integer> map, int n, List<String> list) {
        if (list.size() == 2 * n) {
            if (map.get("(").equals(map.get(")"))) {
                StringBuilder sb = new StringBuilder();
                for (String e : list) {
                    sb.append(e);
                }
                ans.add(sb.toString());

            }
        } else {
            int l = map.get("(");
            int r = map.get(")");
            if (l < n) {
                map.put("(", l + 1);
                list.add("(");
                generate(map, n, list);
                map.put("(", l);
                list.remove(list.size() - 1);
            }
            if (r < l) {
                map.put(")", r + 1);
                list.add(")");
                generate(map, n, list);
                map.put(")", r);
                list.remove(list.size() - 1);
            }
        }
    }
}
