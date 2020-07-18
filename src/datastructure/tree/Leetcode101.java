package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 21:08
 * @Description:
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return check(root.left,root.right);
        }
    }
    public boolean check(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }else if(s!=null&&t!=null){
            if(s.val==t.val){
                return check(s.left,t.right)&&check(s.right,t.left);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
