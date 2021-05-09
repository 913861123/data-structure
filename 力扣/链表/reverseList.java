public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        //只有一个节点
        if (head.next == null) return this.head;

        ListNode cur = this.head;
        ListNode curNext = head.next;
        cur.next = null;
        cur = curNext;
        //头插法
        while (cur != null) {
            curNext = cur.next;
            cur.next = this.head;
            this.head = cur;
            cur = curNext;
        }
        return head;
}

 public ListNode reverseList(ListNode head) {
        if(head == null) return null;  
        //只有一个节点
        if(head.next == null) return head;

        ListNode cur = this.head;
        ListNode curNext = this.head.next;
        ListNode prev = null;//前驱节点
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
}