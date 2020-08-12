package datastructure.list;

/**
 * @Author: liyang27
 * @Date: 2020/7/14 20:39
 * @Description:
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        int move = cnt / 2 + cnt % 2;
        p = head;
        for (int i = 0; i < move; i++) {
            p = p.next;
        }
        ListNode head2 = new ListNode(-1);
        ListNode r;
        while (p != null) {
            r = p.next;
            p.next = head2.next;
            head2.next = p;
            p = r;
        }
        p = head2.next;
        ListNode q = head;
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
