public class TestDemo {
    public static void main(String[] args){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createList();
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(20);
        singleLinkedList.addIndex(2,66);
        singleLinkedList.display();
        System.out.println(singleLinkedList.contains(20));

    }
}
