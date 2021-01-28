package com.yunus.chain;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 列表迭代方式
 * @date 2021/1/28 10:51
 */
public class ListNodeTraverse {


    /**
     * for 循环迭代
     *
     * @param node
     */
    public void traverse1(ListNode node) {
        for (ListNode p = node; p != null; p = node.next) {
            System.out.println(p.val);
        }
    }

    /**
     * while 循环迭代
     *
     * @param node
     */
    public void traverse2(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 递归迭代
     *
     * @param node
     */
    public void traverse3(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        traverse3(node.next);
    }
}
