package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/19 20:33
 * @Description:二叉树中的最大路径和
 */
public class Leetcode124 {
    int len=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return len;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int l=Math.max(dfs(root.left),0);
            int r=Math.max(dfs(root.right),0);
            int sum=l+r+root.val;
            len=Math.max(sum,len);
            return Math.max(l,r)+root.val;
        }
    }
}
