package datastructure.graph.union_find;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 20:03
 * @Description:等式方程的可满足性
 */
public class Leetcode990 {
    int[] parent=new int[26];
    public boolean equationsPossible(String[] equations) {
        if(equations==null||equations.length<1){
            return true;
        }
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(String e:equations){
            if(e.charAt(1)=='='&&e.charAt(0)!=e.charAt(3)){
                union(e.charAt(0)-'a',e.charAt(3)-'a');
            }
        }
        for(String e:equations){
            if(e.charAt(1)=='!'){
                if(connected(e.charAt(0)-'a',e.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int p,int q){
        int rootp=find(p);
        int rootq=find(q);
        if(rootp!=rootq){
            parent[rootp]=rootq;
        }
    }
    public int find(int x){
        while (x!=parent[x]){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }
    public boolean connected(int p,int q){
        int rootp=find(p);
        int rootq=find(q);
        return rootp==rootq;
    }
}
