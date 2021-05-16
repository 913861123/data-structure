class ListNode {
    public  int val;
    public ListNode prev;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    ListNode head = new ListNode(-1);//傀儡节点
    ListNode first;//头节点
    ListNode last;//尾巴节点

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //第一次插入
        if(this.first == null) {
            this.first = node;
            this.last = node;
            this.head.next = node;
        }else {
            this.head.next = node;
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.last == null) {
            this.first = node;
            this.last = node;
            this.head.next = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    //找到插入节点的位置
    public ListNode searchIndex(int index) {
        ListNode cur = this.first;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        //判断合法性
        if(index < 0 || index > size()) {
            System.out.println("index位置不合法");
            return;
        }
        //头插法
        if(index == 0) {
            this.addFirst(data);
            return;
        }
        //尾插法
        if(index == this.size()) {
            this.addLast(data);
            return;
        }
        //中间插入
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.next = cur;
        node.next.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.first;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.first;
        while (cur != null) {
            if(cur.val == key) {
                //要删除的是头节点
                if(cur == this.first) {
                    this.first = this.first.next;
                    this.first.prev = null;
                    this.head.next = this.first;
                }else {
                    //要删除的是尾巴节点或者中间元素
                    cur.prev.next = cur.next;
                    if(cur == this.last) {
                        this.last = this.last.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                //删完结束
                return;
            }else {
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.first;
        while (cur != null) {
            if(cur.val == key) {
                //要删除的是头节点
                if(cur == this.first) {
                    this.first = this.first.next;
                    //假设全部是要删除的数字
                    if(this.first != null) {
                        this.first.prev = null;
                    }else {
                        //把最后一个节点置空
                        this.last = null;
                    }
                    this.head.next = this.first;
                }else {
                    //要删除的是尾巴节点或者中间元素
                    cur.prev.next = cur.next;
                    if(cur == this.last) {
                        this.last = this.last.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.first;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印链表
    public void display() {
        ListNode cur = this.first;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //置空链表
    public void clear() {
        ListNode cur = this.first;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
        this.first = null;
        this.last = null;
    }

}
