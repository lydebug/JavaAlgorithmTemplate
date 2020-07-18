package datastructure.tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 16:44
 * @Description:
 */
public class Leetcode437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }else{
            return sum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        }
    }
    int sum(TreeNode root, int sum){
        if(root==null){
            return 0;
        }else{
            int ret=0;
            if(sum==root.val){
                ret++;
            }
            ret+=sum(root.left,sum-root.val)+sum(root.right,sum-root.val);
            return ret;
        }
    }
}
