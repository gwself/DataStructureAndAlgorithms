package com.yunus.leetcode.level1;

import com.yunus.leetcode.ListNode;

import java.util.*;

/**
 * @author gaoyunfeng
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * @date 2021/3/30 13:36
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        map.put(index, head);
        while (head != null) {
            index += 1;
            head = head.next;
            map.put(index, head);
        }
        return map.get(index - k);
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.pop();
        }
        return res;
    }

}
