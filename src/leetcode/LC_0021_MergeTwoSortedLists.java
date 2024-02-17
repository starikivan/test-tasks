package leetcode;//21. Merge Two Sorted Lists
//        Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//
//
//        Example 1:
//
//
//        Input: l1 = [1,2,4], l2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
//        Example 2:
//
//        Input: l1 = [], l2 = []
//        Output: []
//        Example 3:
//
//        Input: l1 = [], l2 = [0]
//        Output: [0]
//
//
//        Constraints:
//
//        The number of nodes in both lists is in the range [0, 50].
//        -100 <= Node.val <= 100
//        Both l1 and l2 are sorted in non-decreasing order.

public class LC_0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}