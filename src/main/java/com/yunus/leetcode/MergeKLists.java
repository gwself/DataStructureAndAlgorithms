package com.yunus.leetcode;


/**
 * 合并k个有序列表
 * 分治思想  k 个有序列表其实是有多个两个有序合并
 *
 * @author gaoyunfeng
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            int d = length / 2;
            for (int i = 0; i < d; i++) {
                lists[i] = merge2Lists(lists[i], lists[i + d]);
            }
            if ((length & 1) == 1) {
                lists[0] = merge2Lists(lists[0], lists[length - 1]);
            }
            length = length / 2;
        }
        return lists[0];
    }

    /**
     * 合并两个有序列表
     *
     * @param l1 fist chainNode
     * @param l2 two chainNode
     * @return
     */
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.value < l2.value) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }


    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
