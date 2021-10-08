package algorithm.linkedlist;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-06 13:19
 */

public class AddTwoNumbers {

/*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

    请你将两个数相加，并以相同形式返回一个表示和的链表。

    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    */

    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry=0;
        while (cur1!=null || cur2!=null){
            int n1=0,n2 = 0;
            if(cur1!=null) n1 = cur1.val;
            if(cur2!=null) n2 = cur2.val;
            int val = ( n1 + n2 + carry ) % 10;
            carry = ( n1 + n2 + carry ) / 10;
            ListNode node = new ListNode(val,null);
            if(head==null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = tail.next;
            }

            if(cur1!=null) cur1 = cur1.next;
            if(cur2!=null) cur2 = cur2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry,null);
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
