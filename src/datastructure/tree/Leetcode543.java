package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 15:29
 * @Description:
 */
public class Leetcode543 {
    public int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int l=maxDepth(root.left);
            int r=maxDepth(root.right);
            if(l+r>result) result=l+r;
            return Math.max(l,r)+1;
        }
    }
}
