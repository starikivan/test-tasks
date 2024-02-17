/**
24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its
head. You must solve the problem without modifying the values in the list s nodes (i.e., only
nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4] Output: [2,1,4,3]

Example 2:
Input: head = [] Output: []

Example 3:
Input: head = [1] Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */

package leetcode;

public class LC_0024_SwapNodesInPairs {

 public static void main(String[] args) {
  LC_0024_SwapNodesInPairs task = new LC_0024_SwapNodesInPairs();
  ListNode head = new ListNode(1,
      new ListNode(2,
          new ListNode(3,
              new ListNode(4))));
  ListNode result = task.swapPairs(head);
 }

 public ListNode swapPairs(ListNode head) {
  ListNode temp = new ListNode(0, head);
  ListNode previous = temp;
  ListNode current = head;
  while (current != null && current.next != null) {
   ListNode next = current.next;
   current.next = next.next;
   next.next = current;
   previous.next = next;
   previous = current;
   current = current.next;
  }
  return temp.next;
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


