import java.util.concurrent.TimeoutException;

public class TestDemo {
    public static void main(String[] args) {
        TestLinkedList testLinkedList = new TestLinkedList();
        testLinkedList.addFirst(1);
        testLinkedList.addFirst(1);
        testLinkedList.addFirst(1);
        testLinkedList.addFirst(1);
        testLinkedList.addLast(1);
        testLinkedList.addLast(1);
        testLinkedList.addLast(1);
        testLinkedList.display();
        testLinkedList.removeAllKey(1);
        System.out.println("------------------");
        testLinkedList.display();
    }
}
