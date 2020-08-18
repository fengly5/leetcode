package domain;

public class GlobalInitialize {

    public static ListNode initNodes() {
        ListNode listNode = new ListNode(5);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        listNode.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        print(listNode, true);
        return listNode;
    }

    public static ListNode initTwoNodes() {
        ListNode listNode = new ListNode(5);
        ListNode list1 = new ListNode(1);

        listNode.next = list1;
        print(listNode, true);
        return listNode;
    }

    public static ListNode initOneNodes() {
        ListNode listNode = new ListNode(1);
        return listNode;
    }

    public static ListNode initZreoNodes() {
        ListNode listNode = null;
        return listNode;
    }

    public static void print(ListNode listNode) {
        print(listNode, false);
    }

    public static void print(ListNode listNode, boolean sort) {
        if (!sort) {
            System.out.println("排序后：");
        } else {
            System.out.println("排序前：");
        }
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("-------");
    }
}
