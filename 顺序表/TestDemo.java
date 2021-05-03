import java.util.Arrays;


public class TestDemo {

    public static void main(String[] args) {
        //顺序表的对象
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(4,5);
        myArrayList.add(5,6);
        myArrayList.add(2,88);
        myArrayList.display();
        System.out.println(myArrayList.contains(81));
        System.out.println(myArrayList.search(88));
        System.out.println(myArrayList.getPos(6));
        System.out.println(Arrays.toString(myArrayList.elem));
    }
}
