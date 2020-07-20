package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/20 19:53
 * @Description: N皇后
 */
public class Leetcode51 {
    public static void main(String[] args) {
        Leetcode51 A =new Leetcode51();

        List<List<String>> ans=A.solveNQueens(4);
        for(List<String> eles:ans){
            for(String e:eles){
                System.out.println(e);
            }
            System.out.println("======================");
        }
    }
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb =new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            s[i]=sb.toString();
        }
        int[] nums= new int[n];
        NQuenen(n,s,0,nums);
        return res;
    }
    public void NQuenen(int n,String[] s,int r,int[] nums){
        if(r==n){
            List<String> list = new ArrayList<>();
            for(int i: nums){
                list.add(s[i]);
            }
            res.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(nums,r,i)){
                nums[r]=i;
                NQuenen(n,s,r+1,nums);
            }
        }
    }

    public boolean isValid(int[] nums,int r,int c){
        for(int i=0;i<r;i++){
            if(nums[i]==c||Math.abs(r-i)==Math.abs(nums[i]-c)){
                return false;
            }
        }
        return true;
    }
}

