/**
 82. Remove Duplicates from Sorted List II
 Medium

 Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 from the original list. Return the linked list sorted as well.



 Example 1:


 Input: head = [1,2,3,3,4,4,5]
 Output: [1,2,5]
 Example 2:


 Input: head = [1,1,1,2,3]
 Output: [2,3]


 Constraints:

 The number of nodes in the list is in the range [0, 300].
 -100 <= Node.val <= 100
 The list is guaranteed to be sorted in ascending order.

 */

package leetcode;

public class LC_0082_RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;
        while (curr != null) {
            boolean isDuplicate = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                isDuplicate = true;
            }
            if (isDuplicate) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
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
            this.val = val; this.next = next;
        }
    }


}