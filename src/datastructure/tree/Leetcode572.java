package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 20:55
 * @Description:
 */
public class Leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null){
            return true;
        }
        if(s==null){
            return false;
        }
        if(check(s,t)){
            return true;
        }else{
            return isSubtree(s.left,t)||isSubtree(s.right,t);

        }
    }
    public boolean check(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }else if(s!=null&&t!=null){
            if(s.val==t.val){
                return check(s.left,t.left)&&check(s.right,t.right);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
