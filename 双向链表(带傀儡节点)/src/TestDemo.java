public class TestDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(1);
        doubleLinkedList.display();
        doubleLinkedList.removeAllKey(1);
        System.out.println("------------");
        doubleLinkedList.display();
    }
}
