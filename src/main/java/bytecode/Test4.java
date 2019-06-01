package bytecode;

/*
 * 栈帧（Stack frame）
 *  栈帧是一种用于帮助虚拟机执行方法调用和方法执行的数据结构.
 *  栈帧在某一时刻只会归属于一个线程，因此栈帧是没有并发操作的.
 *  栈帧本身是一种数据结构，封装了方法的局部变量表、动态连接信息、方法的返回地址以及操作数栈等信息.
 *  一个栈由多个帧组成，帧就是栈里存储元素的单位. 例如：栈里有3个元素，”2”, “b”, “s”. 那么这个栈里就有3个帧.

* * 静态解析的4种情形：
 * 静态方法
 * 父类方法
 * 构造方法
 * 私有方法（无法被重写）
 * 以上4类方法称为非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用.

 */
public class Test4 {
    public static void test(){
        System.out.println("test invoke");
    }

    public static void main(String[] args) {
        test();
    }
}
