public void removeAllKey(int key){
    ListNode prev = this.head;
    ListNode cur = this.head.next;
    while(cur != null){//头节点遍历不到
        if(cur.val == key){
            prev.next = cur.next;
            cur = prev.next;
        }else{
            prev = cur;
            cur = cur.next;
        }
    }
    //判断头节点是否也是要删除的节点
    if(this.head.val == key){
        this.head = this.head.next;
    }
}