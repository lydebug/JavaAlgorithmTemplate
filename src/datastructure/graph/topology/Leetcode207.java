package datastructure.graph.topology;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 21:14
 * @Description:课程表
 */
public class Leetcode207 {
    public static void main(String[] args) {
        Leetcode207 A = new Leetcode207();
        int[][] pre=new int[][]{{1,0},{0,1}};
        System.out.println(A.canFinish(2,pre));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in=new int[numCourses];
        List<Integer>[] lists =new List[numCourses];
        for (int i=0;i<lists.length;i++){
            lists[i]=new LinkedList<>();
        }
        int cnt=0;
        for(int i=0;i<prerequisites.length;i++){
            in[prerequisites[i][1]]++;
            cnt++;
            lists[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.add(i);
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
                }
            }
        }
        return cnt==0;
    }
}
