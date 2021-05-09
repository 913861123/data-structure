 public ListNode middleNode(ListNode head) {
       if (head == null) return null;
       ListNode slow = this.head;
       ListNode fast = this.head;
       while (fast != null && fast.next != null) {//奇偶数链表情况
           slow = slow.next;
           fast = fast.next.next;

       }
       return slow;
 }