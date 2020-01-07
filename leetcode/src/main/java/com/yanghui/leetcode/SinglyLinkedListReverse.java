package com.yanghui.leetcode;

/**
 * @author YangHui
 */
public class SinglyLinkedListReverse {

    public void test(){
        ListNode head = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        head.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next= list5;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next!= null){

        }

    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return null;
    }


    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
