package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

/**
 * @author gaoyunfeng
 * @Description: 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @date 2021/1/25 13:34
 */
public class IsPalindrome {

    // 左侧指针
    ListNode left;

    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
