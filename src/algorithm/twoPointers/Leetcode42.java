package algorithm.twoPointers;

/**
 * @Author: liyang27
 * @Date: 2020/8/14 14:12
 * @Description:接雨水
 */
public class Leetcode42 {
    public static void main(String[] args) {
        Leetcode42 A = new Leetcode42();
        int[] trap={0,2,0};
        System.out.println(A.trap(trap));
    }
    public int trap(int[] height) {
        if(height==null||height.length<3){
            return 0;
        }
        int left=height[0],right=height[height.length-1];
        int i=1,j=height.length-2;
        int ans=0;
        int min=0;
        while(i<=j){
            while(height[i]>=left){
                left=height[i];
                i++;
            }
            while(height[j]>=right){
                right=height[j];
                j--;
            }
            if(i>j){
                break;
            }
            if(left<right){
                ans+=left-height[i];
                i++;
            }else{
                ans+=right-height[j];
                j--;
            }
        }
        return ans;
    }
}
