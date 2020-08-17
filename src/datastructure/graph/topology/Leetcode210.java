package datastructure.graph.topology;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 21:15
 * @Description:课程表2
 */
public class Leetcode210 {
    public static void main(String[] args) {
        Leetcode210 A =new Leetcode210();
        int[][] course=new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(A.findOrder(4,course)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in=new int[numCourses];
        List<Integer>[] lists =new List[numCourses];
        for (int i=0;i<lists.length;i++){
            lists[i]=new LinkedList<>();
        }
        int cnt=0;
        int[] ans=new int[numCourses];
        int idx=0;
        for(int i=0;i<prerequisites.length;i++){
            in[prerequisites[i][0]]++;
            cnt++;
            lists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.add(i);
                ans[idx++]=i;
            }
        }
        while (!queue.isEmpty()){
            int tmp=queue.poll();
            List<Integer> list = lists[tmp];
            for(int i=0;i<list.size();i++){
                in[list.get(i)]--;
                cnt--;
                if(in[list.get(i)]==0){
                    queue.offer(list.get(i));
                    ans[idx++]=list.get(i);
                }
            }
        }

        return cnt==0?ans:new int[]{};
    }

}
