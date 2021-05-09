public ListNode FindKthToTail(int k) {
    if(k <= 0 || this.head ==null) return null;

    ListNode fast = this.head;
    ListNode slow = this.head;
    //让fast先走 k-1 步数
    while(k-1 != 0){
        if(fast.next != null){
            fast = fast.next;
        }else{//判断k是否越界
            System.out.println("k位置不合法");
            return null;
        }
    }
    //让fast和slow同时走
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}