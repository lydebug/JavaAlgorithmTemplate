package algorithm.twoPointers;

/**
 * @Author: liyang27
 * @Date: 2020/8/14 15:42
 * @Description:
 */
public class Leetcode84 {

    public static void main(String[] args) {
        Leetcode84 A = new Leetcode84();
        System.out.println(A.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length<1){
            return 0;
        }
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        int maxV=0;
        left[0]=-1;
        right[heights.length-1]=heights.length;
        for(int i=1;i<heights.length;i++){
            int tmp=i-1;
            while(tmp!=-1&&heights[i]<=heights[tmp]){
                tmp=left[tmp];
            }
            left[i]=tmp;
        }
        for(int i=heights.length-2;i>=0;i--){
            int tmp=i+1;
            while (tmp!=heights.length&&heights[i]<=heights[tmp]){
                tmp=right[tmp];
            }
            right[i]=tmp;
        }
        for(int i=0;i<heights.length;i++){
            int lo=left[i]+1;
            int hi=right[i]-1;
            int width=hi-lo+1;
            maxV=Math.max(width*heights[i],maxV);

        }
        return maxV;
    }
}
