package datastructure.list;

/**
 * @Author: liyang27
 * @Date: 2020/7/14 21:10
 * @Description:
 */
public class Leetcode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p=root,r=null;
        int len=0;
        while(p!=null){
            p=p.next;
            len++;
        }
        int num=len/k;
        int cnt=len%k;
        ListNode[] listNodes= new ListNode[k];
        p=root;
        for(int i=0;i<k;i++){
            listNodes[i]=p;
            if(p!=null){
                int tlen=num;
                if(cnt>0){
                    cnt--;
                    tlen++;
                }
                while(tlen>1){
                    tlen--;
                    p=p.next;
                }
                r=p;
                p=p.next;
                r.next=null;
            }

        }

        return listNodes;
    }
}
