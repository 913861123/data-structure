
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode (int val) {
        this.val = val;
    }
}

public class TestLinkedList {
    public ListNode head;
    public ListNode last;
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //第一次插入
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //第一次插入
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    //找要插入的节点的位置
    public ListNode searchIndex(int index) {
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return  cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        //判断index位置的合法性
        if(index < 0 || index > this.size()) {
            System.out.println("index的位置不合法");
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
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
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
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                //要删除的是头节点
                if(this.head == cur) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    //尾巴节点和中间的节点两种情况
                    cur.prev.next = cur.next;
                    if(this.last == cur) {
                        //删除尾巴节点
                        cur = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                //已经删完了
                return;
            }else {
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                //要删除的是头节点
                if(this.head == cur) {
                    this.head = this.head.next;
                    if(this.head != null) {
                        this.head.prev = null;
                    }
                }else {
                    //尾巴节点和中间的节点两种情况
                    cur.prev.next = cur.next;
                    if(this.last == cur) {
                        //删除尾巴节点
                        cur = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                //走一步
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }
    }
    //得到链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //置空链表
    //内存泄露：JPS   jmap -live:histo 进程号 > 文件
    public void clear() {
        ListNode cur = this.head;
        //一个一个置空
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
        this.last = null;
    }

}
