package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 21:14
 * @Description:
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }else if(root.left==null&&root.right!=null){
                return 1+minDepth(root.right);
        }else if(root.right==null&&root.left!=null){
            return 1+minDepth(root.left);
        }else{
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
    }
}
