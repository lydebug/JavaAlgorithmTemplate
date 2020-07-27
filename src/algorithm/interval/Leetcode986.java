package algorithm.interval;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/27 20:58
 * @Description:区间列表的交集
 */
public class Leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A==null||B==null){
            return new int[0][0];
        }
        int p=0,q=0;
        List<int[]> list= new LinkedList<>();
        while(p<A.length&&q<B.length){
            int a1=A[p][0],a2=A[p][1];
            int b1=B[q][0],b2=B[q][1];
            if(a2>=b1&&a1<=b2){
                int[] tmp = {Math.max(a1,b1),Math.min(a2,b2)};
                list.add(tmp);
            }
            if(a2>b2){
                q++;
            }else{
                p++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
