package datastructure.tree;

/**
 * TODO
 *
 * @author Leon
 * @since 2020/07/19
 */
public class Leetcode337 {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=root.left==null?0:rob(root.left.right)+rob(root.left.right);
        int r=root.right==null?0:rob(root.right.left)+rob(root.right.right);
        int c=rob(root.left)+rob(root.right);
        return Math.max(l+r+root.val,c);
    }

}
