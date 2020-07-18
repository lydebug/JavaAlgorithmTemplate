package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 14:57
 * @Description:
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
