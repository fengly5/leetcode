package leetcode;

import domain.GlobalInitialize;
import domain.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 */
public class linkedListCycle {

    /**
     * set缓存
     *
     * @param listNode
     * @return
     */
    public static boolean hasCycleFirst(ListNode listNode) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while (listNode != null) {
            if (nodeSet.contains(listNode)) {
                return true;
            }
            nodeSet.add(listNode);
            listNode = listNode.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param listNode
     * @return
     */
    public boolean hasCycleSecond(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode initNodes = GlobalInitialize.initNodes();
        ListNode twoNodes = GlobalInitialize.initTwoNodes();
        ListNode oneNodes = GlobalInitialize.initOneNodes();
        System.out.println(hasCycleFirst(initNodes));
        System.out.println(hasCycleFirst(twoNodes));
        System.out.println(hasCycleFirst(oneNodes));
    }
}
