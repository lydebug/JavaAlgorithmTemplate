package datastructure.heap;

import java.util.Comparator;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 16:13
 * @Description: 最大堆的实现
 */
public class MaxPQ <Key extends Comparable<Key>>{
    //存储元素的数组
    private Key[] pq;
    //当前Priority Queue中的元素个数
    private int N=0;

    public MaxPQ(int cap){
        pq=(Key[])new Comparator[cap+1];

    }

    public Key max(){
        return pq[1];
    }
    public int parent(int root){
        return root/2;
    }
    public int left(int root){
        return root*2;
    }
    public int right(int root){
        return root*2+1;
    }

    public void insert(Key e){
        pq[++N]=e;
        swim(N);
    }
    public Key delMax(){
        Key max=pq[1];
        pq[1]=pq[N];
        pq[N]=null;
        N--;
        sink(1);
        return max;
    }
    private void swim(int k){
        while(k>1&&less(parent(k),k)){
            exch(parent(k),k);
            k=parent(k);
        }
    }
    private void sink(int k){
        while(left(k)<=N){
            int bigger=left(k);
            if(right(k)<=N&&less(bigger,right(k))){
                bigger=right(k);
            }
            if(less(k,bigger)){
                exch(k,bigger);
            }else{
                break;
            }
            k=bigger;
        }
    }
    private void exch(int i,int j){
        Key tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }
}
