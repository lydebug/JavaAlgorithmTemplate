package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 21:29
 * @Description:
 */
public class Leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            if(root.left!=null&&root.left.left==null&&root.left.right==null){
                return root.left.val+sumOfLeftLeaves(root.right);
            }else{
                return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
            }
        }
    }
}
