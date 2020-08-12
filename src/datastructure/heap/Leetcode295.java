package datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liyang27
 * @Date: 2020/8/12 18:01
 * @Description:数据流的中位数
 */
public class Leetcode295 {
}

class MedianFinder {
    private PriorityQueue<Integer> maxQ;
    private PriorityQueue<Integer> minQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQ=new PriorityQueue<>(Comparator.reverseOrder());
        minQ=new PriorityQueue<>(Integer::compareTo);
    }

    public void addNum(int num) {
        if(minQ.isEmpty()||num>minQ.peek()){
            minQ.offer(num);
        }else{
            maxQ.offer(num);
        }
        if(maxQ.size()-minQ.size()>1){
            minQ.offer(maxQ.poll());
        }else if(minQ.size()-maxQ.size()>1){
            maxQ.offer(minQ.poll());
        }
    }

    public double findMedian() {
        return maxQ.size()==minQ.size()?(maxQ.peek()+minQ.peek())*1.0/2:(maxQ.size()>minQ.size()?maxQ.peek():minQ.peek());
    }
}
