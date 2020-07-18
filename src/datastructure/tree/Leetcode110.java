package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 15:10
 * @Description:
 */
public class Leetcode110 {
    /*public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(!check(tmp)){
                return false;
            }
            if(tmp.left!=null){
                queue.offer(tmp.left);
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
            }
        }
        return true;
    }
    public boolean check(TreeNode node){
        if(node==null){
            return true;
        }else{
            return Math.abs(maxDepth(node.left) - maxDepth(node.right)) <= 1;
        }
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }*/
    public boolean flag=true;
    public boolean isBalanced(TreeNode root){
        MaxDepth(root);
        return flag;
    }
    public int MaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=MaxDepth(root.left);
        int r=MaxDepth(root.right);
        if(Math.abs(l-r)>1) flag=false;
        return Math.max(l,r)+1;
    }
}
