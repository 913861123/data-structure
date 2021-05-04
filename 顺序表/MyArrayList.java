import java.util.Arrays;

/**
 * 简单的顺序表思路
 */
public class MyArrayList {

    //实例成员变量：如果不初始化默认值就是对应的0值
    public int[] elem;//只是定义了一个引用
    public int usedSize;//有效的数据个数

    public MyArrayList() {
        this.elem = new int[5];
    }

    public boolean judge(){//判断是否要增容
        if(this.usedSize == this.elem.length){
            return true;
        }else{
            return false;
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断是否要增容
        if(judge()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }
        //判读那位合法性
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }
        //判断元素是否要插入
        for (int i = this.usedSize; i > pos; i++) {
            this.elem[i] = this.elem[i+1];
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
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {//这里仅仅是针对正数情况
        if(pos<0 || pos > this.usedSize){
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        int index = search(key);//找元素下标
        if(index == -1){
            System.out.println("key关键字不存在");
            return;
        }
        for (int i = index; i < this.usedSize; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {//这里只是比较简单的思路而已，如果里面是对象则需要值位 null
        this.usedSize = 0;
    }

}
