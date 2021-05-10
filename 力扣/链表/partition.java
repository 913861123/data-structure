public ListNode partition(ListNode head,int x) {
        if (head.next == null) return null;
        //x左边
        ListNode leftA = null;
        ListNode leftB = null;
        //x右边
        ListNode rightA = null;
        ListNode rightB = null;
        while (head != null) {
            if (head.val < x) {
                //第一次插入
                if (leftA == null) {
                    leftA = this.head;
                    leftB = this.head;
                }else {//不是第一次插入
                    leftB.next = this.head;
                    leftB = leftB.next;
                }
            }else {
                //第一次插入
                if (rightA == null) {
                    rightA = this.head;
                    rightB = this.head;
                }else {//不是第一次插入
                    rightB.next = this.head;
                    rightB = rightB.next;
                }
            }
            head = head.next;
        }

        //判断x左边是否有元素
        if(leftA == null){
            return rightA;
        }
        leftB.next = rightA;
        //判读最后一个元素的next是否为空
        if(rightA != null){
            rightB.next = null;
        }
        return leftA;
    }