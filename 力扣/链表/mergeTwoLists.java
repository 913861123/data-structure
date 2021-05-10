public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHand = new ListNode();//傀儡节点
        ListNode tmp = newHand;
        while(headA != null && headB != null){
            if(headA.val < headB.val){
                tmp.next = headA;
                tmp = headA;
                headA = headA.next;
            }else{
                tmp.next = headB;
                tmp = headB;
                headB = headB.next;
            }
        }
        if(headA == null){
            tmp.next = headB;
        }else{
            tmp.next = headA;
        }
       return newHand.next;
   }