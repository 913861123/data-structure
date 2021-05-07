
class ListNode {
    public int val;//值
    public ListNode next;//存储下一个节点的地址  也就是说 这个是一个引用

    public ListNode(){

    }
    public ListNode(int val){
        this.val = val;
    }
}

public class SingleLinkedList {
    public ListNode head;//用来标识链表的头部
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);

        if(this.head == null){//当链表为空时
                this.head = node;
        }else{
            //找尾巴
            ListNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        //判断位置合法性
        if(index < 0 || index >size()){
            System.out.println("index位置不合法");
            return;
        }
        //头插
        if(index == 0){
            this.addFirst(data);
        }
        //尾插
        if(index == this.size()){
            this.addLast(data);
        }
        //选择插入
        ListNode node = new ListNode(data);
        ListNode cur = findIndexSubOne(index);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 从引用头开始，走 index-1 步
     * @param index
     * @return
     */
    public ListNode findIndexSubOne(int index){
        ListNode cur = this.head;
        for(int i = 0; i < index-1; i++){
                cur = cur.next;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                if(cur == this.head){
                    head = cur.next;
                    cur = null;
                }else if(cur.next == null){

                }
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                cur = cur.next;
            }
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //遍历链表
    public void display(){
        ListNode cur = this.head;
        //不能是this.head.next != null  这样写最后一个节点是不能被打印的
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        //需要置空的节点
        ListNode cur = this.head;
        //一个一个置空
        while(cur != null){
            ListNode cunNext = cur.next;
            cur.next = null;
            cur = cunNext;
        }
        this.head = null;
    }
}

