package datastructure.lru;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 16:37
 * @Description:
 */
public class Node {
    public int key,val;
    public Node next,prev;
    public Node(int k,int v){
        this.key=k;
        this.val=v;
    }
}
