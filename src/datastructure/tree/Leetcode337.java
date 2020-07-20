package datastructure.tree;

import java.util.HashMap;
import java.util.Map;

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
        int l=root.left==null?0:rob(root.left.left)+rob(root.left.right);
        int r=root.right==null?0:rob(root.right.left)+rob(root.right.right);
        int c=rob(root.left)+rob(root.right);
        return Math.max(l+r+root.val,c);
    }

    public int rob2(TreeNode root){
        Map<TreeNode,Integer> map = new HashMap<>();
        return robWithMemo(root,map);
    }
    public int robWithMemo(TreeNode root,Map<TreeNode,Integer> memo){
        if(root==null){
            return 0;
        }else{
            if(memo.containsKey(root)){
                return memo.get(root);
            }else{
                int l=root.left==null?0:robWithMemo(root.left.left,memo)+robWithMemo(root.left.right,memo);
                int r=root.right==null?0:robWithMemo(root.right.left,memo)+robWithMemo(root.right.right,memo);
                int c=robWithMemo(root.left,memo)+robWithMemo(root.right,memo);
                int result=Math.max(l+r+root.val,c);
                memo.put(root,result);
                return result;
            }
        }
    }


}
