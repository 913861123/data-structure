public class TestDemo {
    public static void main(String[] args){
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        singleLinkedList.addLast(7);
        singleLinkedList.display();
        ListNode ret = singleLinkedList.reverseList(singleLinkedList.head);
        singleLinkedList.display2(ret);


    }
}
