package leetcode;

import domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试出镜率较高
 * 主要考察的代码的简洁程度
 * 我第一次是没有做到简洁的，用到的是方法一，循环的方式
 *
 * 代码的关键是，记录当前节点的下一个节点，然后循环即可
 */
public class ReverseLinkedList {
    public static ListNode reverseListMethodFrist(ListNode head) {
        List<ListNode> listNodes = new ArrayList<ListNode>();
        ListNode reverseListNode = new ListNode(0);
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        int sizes = listNodes.size();
        for (int i = listNodes.size() - 1; i > -1; i--) {
            if (i == listNodes.size() - 1) {
                reverseListNode = listNodes.get(i);
            } else {
                listNodes.get(i + 1).next = listNodes.get(i);
            }
            if (i == 0) {
                listNodes.get(0).next = null;
            }
        }
        return reverseListNode;
    }

    public static ListNode reverseListMethodSecond(ListNode head) {
        ListNode prv = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = prv;
            prv = cur;
            cur = tempNode;
        }
        return prv;
    }

    public static void main(String[] args) {
        ListNode listNode = init();
        print(listNode);
        ListNode second = reverseListMethodSecond(listNode);
        print(second);
    }

    private static ListNode init() {
        ListNode listNode = new ListNode(5);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        listNode.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        return listNode;
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("-------");
    }
}
