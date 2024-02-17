/**
1721. Swapping Nodes in a Linked List
Medium

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from
the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
*/

package leetcode;

public class LC_1721_SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode second = fast;
        while (fast.next != null) {
            fast = fast.next;
            first = first.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
