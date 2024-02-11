public class ReverseLinkedList {

  public static void main(String[] args) {
    // Example usage
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    System.out.println("Original Linked List:");
    printList(head);

    ListNode reversedList = reverseList(head);

    System.out.println("Reversed Linked List:");
    printList(reversedList);
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  private static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    // take first pointer for head
    ListNode current = head;

    while (current != null) {
      ListNode nextNode = current.next;
      current.next = prev;
      prev = current;
      current = nextNode;
    }
    return prev;
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      // move pointer to next element
      current = current.next;
    }
    System.out.println();
  }
}
