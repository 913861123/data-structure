
/**
 * Created with IntelliJ IDEA.
 * Description:
 * Java集合当中 LinkedList 底层是一个双向链表  这里只是用了一下名字
 * User: GaoBo
 * Date: 2021-04-27
 * Time: 19:20
 */

class ListNode {
    public int val;//值
    public ListNode next;//存储下一个节点的地址  也就是说 这个是一个引用

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }
}


public class SingleLinkedList {

    public ListNode head;//标识整个链表的头

    //得到单链表的长度
    public int size() {
        int cont = 0;
        ListNode tmp = this.head;
        while(tmp != null){
            cont++;
            tmp = tmp.next;
        }
        return cont;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode tmp = this.head;
        if(tmp == null){//当链表为空时
            this.head = node;
        }else{
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }

    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //判断index位置合法性
        if(index < 0 || index > this.size()){
            System.out.println("index位置合法性");
            return;
        }
        //头插法
        if(this.size() == 0){
            this.addFirst(data);
        }
        //尾插法
        if(this.size() == index){
            this.addLast(data);
        }
        ListNode node = new ListNode(data);
        ListNode tmp = findIndexSubOne(index);
        node = tmp;
        tmp = node.next;
    }

    /**
     * 让引用从头开始走 index-1步
     * @param index
     * @return
     */
    public ListNode findIndexSubOne(int index){
        ListNode tmp = this.head;
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode tmp = this.head;
        while(tmp != null){
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {

    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {

    }


    public void clear() {

    }

    /**
     * 穷举法，最low的方式 先建造一个链表出来，让你来感受一下
     */
    public void createList() {
        ListNode listNode1 = new ListNode(12);//12
        ListNode listNode2 = new ListNode(45);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        this.head = listNode1;//head引用  引用了 listNode1引用  引用的对象

    }

    /**
     * 遍历链表：
     */
    public void display() {
        ListNode cur = this.head;
        //不能是this.head.next != null  这样写 最后一个节点是不能被打印的
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
