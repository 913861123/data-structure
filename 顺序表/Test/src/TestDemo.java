import java.sql.SQLOutput;
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
        myArrayList.add(6,7);
        myArrayList.add(7,8);
        myArrayList.display();
        myArrayList.remove(11);
        myArrayList.remove(5);
        myArrayList.display();
    }
}
