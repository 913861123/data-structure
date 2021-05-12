import java.util.Arrays;

/**
 * 简单的顺序表思路
 */
public class MyArrayList {
    public int[] elem;//只是定义了一个引用
    public int usedSize;//有效的数据个数

    public MyArrayList () {//初始化一个数组
        this.elem = new int[5];
    }
    //增容判断
    public boolean isFull() {
        if(this.elem.length == this.usedSize){
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断是否需要增容
        if(this.isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //判断pos位置合法性
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        //从后往前挪元素
        for (int i = this.usedSize; pos < i; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) return true;
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) return i;
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        //判断合法性
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        //判断合法性
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        int ret = search(key);
        if(ret == -1) {
            System.out.println("关键字key不存在");
            return;
        }
        for (int i = ret; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
