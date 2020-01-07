package com.yanghui.leetcode;

import org.junit.Test;

/**
 * @author YangHui
 */
public class Problem25 {

    @Test
    public void test(){
        ListNode list = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next= list5;
        ListNode listNode = reverseKGroup(list, 2);
        for(;listNode!=null;listNode = listNode.next){
            System.out.print(listNode.val + " ");
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;
        while(end.next != null) {
            for(int i = 0; i<k && end != null; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
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
        return pre;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

