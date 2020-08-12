package datastructure.lru;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 16:37
 * @Description:双向循环链表
 */
public class DoubleList {
    private int sz;
    Node head;

    public DoubleList() {
    }

    public DoubleList(int sz) {
        this.sz = sz;
    }

    public void addFirst(Node x) {
        if (head != null) {
            Node tail = head.prev;
            x.next = head;
            x.prev = tail;
            head.prev = x;
            tail.next = x;
        } else {
            x.next = x;
            x.prev = x;
        }
        head = x;
    }

    public void remove(Node x) {
        Node prev = x.prev;
        Node next = x.next;
        if (next == x) {
            head = null;
        } else {
            if (head == x) {
                head = next;
            }
            prev.next = next;
            next.prev = prev;
        }
    }

    //删除最后一个节点并返回
    public Node removeLast() {
        Node x = head.prev;
        remove(x);
        return x;
    }

    public int size() {
        return sz;
    }
}
