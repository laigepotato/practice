package algorithm.linkedlist;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-03 21:33
 */

public class LinkedListPractice {

    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
         slow = slow.next;
         fast = fast.next.next;
        if(slow==fast)
            return true;
        }
        return false;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;

        ListNode pre = new ListNode(null);
        pre.next = head;
        while (head.next!=null){
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return pre.next;
    }


    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head==null || m>=n )
            return head;
        ListNode pre = head;
        for(int i=1;i<m-1;i++)
            pre = pre.next;
        ListNode cur = pre.next;
        for(int i=m;i<=n;i++){
            //??????
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
        }
        return head;
    }


/*
    输入一个链表，输出该链表中倒数第k个节点。
    1.双指针求解：最简单的方式就是使用两个指针，第一个指针先移动k 步，
    然后第二个指针再从头开始，这个时候这两个指针同时移动，当第一个指针到链表 的末尾的时候，返回第二个指针即可。
    2.这题要求的是返回后面的k个节点，我们只要把原链表的结点全部压栈，然后再把栈中最 上面的k个节点出栈，出栈的结点重新串成一个新的链表即可
*/
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (k-- > 0){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }



    public static void main(String[] args) {

    }
}
