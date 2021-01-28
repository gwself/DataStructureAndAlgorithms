package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 237. 删除链表中的节点
 * @date 2021/1/28 10:21
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
