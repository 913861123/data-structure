import java.util.Arrays;

public class MyArrayList {

    //实例成员变量：如果不初始化默认值就是对应的0值
    public int[] elem;//只是定义了一个引用
    public int usedSize;//有效的数据个数

    public MyArrayList() {
        this.elem = new int[5];
    }

    public  boolean judge (int lens) {//判断增容
        if(lens == this.elem.length) {
            return true;
        }else{
            return false;
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断是否要增容
        if(this.judge(this.usedSize)){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //判断pow是否合法
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("输入的pos下标不合法");
            return;
        }
        //插入元素
        for(int i = this.usedSize-1;pos <= i;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        System.out.println("添加成功");
    }
    // 打印顺序表
    public void display(){
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
    public int getPos(int pos) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == pos){
                return this.elem[i];
            }
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) { }
    // 获取顺序表长度
    public int size() {
        return this.elem.length;
    }
    // 清空顺序表
    public void clear() {}

}

