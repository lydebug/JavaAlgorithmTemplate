package algorithm.math;

/**
 * @Author: liyang27
 * @Date: 2020/8/14 16:25
 * @Description:计数质数
 */
public class Leetcode204 {
    public static void main(String[] args) {
        Leetcode204 A =new Leetcode204();
        System.out.println(A.countPrimes(499979));
    }
    public int countPrimes(int n) {
        int cnt=0;
        if(n<2){
            return 0;
        }
        boolean[] prime = new boolean[n];
        for(long i=2;i<n;i++){
            if(!prime[(int)i]){
                for (long j=i*i;j<n;j+=i){
                    prime[(int)j]=true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(!prime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
