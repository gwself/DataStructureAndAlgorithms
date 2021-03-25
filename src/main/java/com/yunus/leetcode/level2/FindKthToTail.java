package com.yunus.leetcode.level2;

import com.yunus.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyunfeng
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=188&tqId=38050&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * @date 2021/3/25 10:39
 */
public class FindKthToTail {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        List<ListNode> list = new ArrayList<>();
        while (pHead != null) {
            list.add(pHead);
            pHead = pHead.next;
        }
        if (list.size() >= k) {
            return list.get(list.size() - k);
        }
        return null;
    }

}
