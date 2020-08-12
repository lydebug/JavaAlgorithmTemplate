package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 15:41
 * @Description:
 */
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        invertTree(l);
        invertTree(r);
        return root;
    }
}
