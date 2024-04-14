public class FastSlowPointerLinkedList {

  public static void main(String[] args) {
    // read input
    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    // Find the middle node
    ListNode middle = fastSlowPointer(head);
    System.out.println("Middle node value: " + middle.val); // Output: Middle node value: 3
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode fastSlowPointer(ListNode head) {
    if (head == null || head.next == null) {
      return head; // return head if the list is empty or has one node
    }
    ListNode slow = head;
    ListNode fast = head;

    // move the fast pointer two steps and the slow pointer one step at a time
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // at this point the slow pointer is at the middle node
    return slow;
  }
}
