public ListNode deleteDuplication() {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //多走一部
                cur = cur.next;
            }else{
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        //把最后一个节点的next值置为null
        tmp.next = null;
        return newHead.next;
}