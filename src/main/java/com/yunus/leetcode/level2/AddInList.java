package com.yunus.leetcode.level2;

import com.yunus.leetcode.ListNode;

import java.util.Stack;

/**
 * @author gaoyunfeng
 * @Description: 两个链表生成相加链表
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=188&tqId=38058&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * @date 2021/3/25 13:52
 */
public class AddInList {


    /**
     * 采用栈先进后出的特点计算每一位的累加和
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                st1.push(head1.val);
                head1 = head1.next;
            }
            if (head2 != null) {
                st2.push(head2.val);
                head2 = head2.next;
            }
        }
        ListNode head = new ListNode(-1);
        int carry = 0;
        //这里设置carry!=0,是因为当st1,st2都遍历完时，如果carry=0,就不需要进入循环了
        while (!st1.empty() || !st2.empty() || carry != 0) {
            int a = 0, b = 0;
            if (!st1.empty()) {
                a = st1.pop();
            }
            if (!st2.empty()) {
                b = st2.pop();
            }
            //每次的和应该是对应位相加再加上进位
            int sum = a + b + carry;
            //对累加的结果取余
            int ans = sum % 10;
            //如果大于0，就进位
            carry = sum / 10;
            //创建节点
            ListNode cur = new ListNode(ans);
            cur.next = head.next;
            //每次把最新得到的节点更新到head->next中
            head.next = cur;
        }
        return head.next;
    }
}
