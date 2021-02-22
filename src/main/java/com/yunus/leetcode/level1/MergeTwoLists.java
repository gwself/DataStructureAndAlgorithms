package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 21. 合并两个有序链表
 * @date 2021/2/22 10:27
 */
public class MergeTwoLists {

    /**
     * 合并两个有序链表
     *
     * @param l1 fist
     * @param l2 second
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

}
