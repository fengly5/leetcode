package leetcode;

import domain.GlobalInitialize;
import domain.ListNode;

public class SwapNodesInPairs {

    /**
     * 递归的关注点
     * 1.返回值
     * 2.调用单元做了什么
     * 3.终止条件
     */
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = swapPairs(cur.next);
        cur.next = head;
        return cur;
    }

    /**
     * 使用一个头节点，减少很多的对头和对尾的判断
     * temp和pre引用同一个指针
     * 记录两个临时的节点变量
     *
     * @param head
     * @return
     */
    private static ListNode swapPairsSecond(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null & temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = GlobalInitialize.initNodes();
        ListNode reverse = swapPairsSecond(listNode);
        GlobalInitialize.print(reverse);
    }
}
