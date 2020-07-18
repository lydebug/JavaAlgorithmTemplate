package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 15:45
 * @Description:
 */
public class Leetcode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1!=null&&t2!=null){
            t1.val=t1.val+t2.val;
            t1.left=mergeTrees(t1.left,t2.left);
            t1.right=mergeTrees(t1.right,t2.right);
        }else if(t1==null&&t2!=null){
            t1=t2;
            t2=null;
        }
        return t1;
    }
}
