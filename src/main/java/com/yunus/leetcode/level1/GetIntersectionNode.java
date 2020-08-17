package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 相交链表
 * @date 2020/8/1710:09
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
