package datastructure.tree;

import com.sun.source.tree.Tree;

/**
 * @Author: liyang27
 * @Date: 2020/7/19 20:54
 * @Description:从前序和中序遍历构造二叉树
 */
public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length<1){
            return null;
        }
        return build(null,preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(TreeNode root,int[] pre,int s1,int e1,int[] in, int s2,int e2){
        if(s1<=e1){
            root=new TreeNode(pre[s1]);
        }else{
            return null;
        }
        int i=s2;
        for(;i<=e2;i++){
            if(in[i]==pre[s1]){
                break;
            }
        }
        int d=i-s2;
        root.left=build(root.left,pre,s1+1,s1+d,in,s2,i-1);
        root.right=build(root.right,pre,s1+d+1,e1,in,i+1,e2);
        return root;
    }
}
