package algorithm.dp.rob;

import datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 09:15
 * @Description:打家劫舍三
 */
public class Leetcode337 {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        } else {
            int[] l = robInternal(root.left);
            int leftVal = Math.max(l[0], l[1]);
            int[] r = robInternal(root.right);
            int rightVal = Math.max(r[0], r[1]);
            int[] result = new int[2];
            result[0] = leftVal + rightVal;
            result[1] = root.val + l[0] + r[0];
            return result;
        }
    }
}
