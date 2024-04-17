/**
83. Remove Duplicates from Sorted List
Easy

Given the head of a sorted linked list, delete all duplicates such that each element appears only
once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

package leetcode;

public class LC_0083_RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode temp = new ListNode(0, head);
    ListNode current = temp.next;
    while (current.next != null) {
      if (current.val == current.next.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
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
