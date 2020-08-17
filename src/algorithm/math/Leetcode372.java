package algorithm.math;

/**
 * @Author: liyang27
 * @Date: 2020/8/14 17:09
 * @Description:
 */
public class Leetcode372 {
    public static void main(String[] args) {
        Leetcode372 A =new Leetcode372();
        int a=2;
        int[] b={1,0};
        System.out.println(A.superPow(a,b));
    }
    public int superPow(int a, int[] b) {
        if(b==null||b.length<1){
            return a%1337;
        }
        int idx=b.length-1;
        int ans=superPow(a,b,idx);
        return ans;
    }

    public int superPow(int a,int[] b,int idx){
        if(idx<0){
            return 1;
        }else{
            int t1=myPow(a,b[idx]);
            int t2=myPow(superPow(a,b,idx-1),10);
            return (t1%1337*t2%1337)%1337;
        }
    }
    public int myPow(int a,int b){
        int t=a,c=1;
        while(b!=0){
            if(b%2!=0){
                c=((c%1337)*(t%1337))%1337;
            }
            t=((t%1337)*(t%1337))%1337;
            b=b/2;
        }
        return c;
    }

}
