package datastructure.list;

/**
 * @Author: liyang27
 * @Date: 2020/7/18 14:39
 * @Description:
 */
public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode m = head;
        while (m.next != null && m.next.next != null) {
            m = m.next.next;
        }
        ListNode p = head, r = m;
        ListNode q = head.next;
        while (p != m && q != null) {
            p.next = q.next;
            q.next = r.next;
            r.next = q;
            r = q;
            p = p.next;
            q = p.next;
        }
        return head;
    }

//    public ListNode oddEvenList(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode odd = head, even = head.next, evenHead = even;
//        while (even != null && even.next != null) {
//            odd.next = odd.next.next;
//            odd = odd.next;
//            even.next = even.next.next;
//            even = even.next;
//        }
//        odd.next = evenHead;
//        return head;
//    }

}
