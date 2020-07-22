package algorithm.dp;

/**
 * @Author: liyang27
 * @Date: 2020/7/22 17:17
 * @Description:买卖股票的最佳时机 IV
 */
public class Leetcode188 {
    public static void main(String[] args) {
        Leetcode188 A = new Leetcode188();
        int k=11;
        int[] prices={48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
        System.out.println(A.maxProfit(k,prices));
    }
    public int maxProfit(int k, int[] prices) {
        return 0;
    }
    /*int ans=0;
    public int maxProfit(int k, int[] prices) {
        int state=0;//0表示可以购买，大于0表示持有股票
        buy(k,0,prices,0,true);
        return ans;
    }
    public void buy(int k,int step,int[] prices,int salary,boolean flag){
        if(k==0||step>=prices.length){
            ans=Math.max(salary,ans);
            return ;
        }

        if(flag){
            buy(k,step+1,prices,salary-prices[step],false);
            buy(k,step+1,prices,salary,flag);
        }else{
            //出不出售
            buy(k-1,step+1,prices,salary+prices[step],true);
            buy(k,step+1,prices,salary,false);
        }
    }*/
}
