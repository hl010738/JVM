package memory;

import java.util.ArrayList;
import java.util.List;

/*
* JVM内存空间的元素
    * 虚拟机栈（stack frame）：存放对象的引用. 引用的也占用一定的内存空间. 程序都是通过引用来操作对象. 线程私有
    * 程序计数器（program counter）：作用是表示线程执行代码的顺序和跳转位置，以及线程切换时线程挂起的状态. 线程私有.
    * 本地方法栈：执行本地方法（native 方法）.
    * 堆（Heap）：存放对象实例. 堆内存是所有线程共享的. 与堆相关的一个重要概念是垃圾收集器. 现代虚拟机都采用分代收集算法. 因此，堆空间也基于此进行划分为：新生代和老年代.
    * 方法区（method area）：存放元数据. 永久代（permanent generation）, JDK1.8开始放弃，使用元空间（meta space）代替.
    * 运行时常量池：存放运行时一部分方法区的数据.
    * 直接内存（Direct memory）. 这部分不是还有JVM直接管理的，与Java NIO相关. JVM通过DirectByteBuffer来操作直接内存，
    * 对象的内存数据由2个部分构成：一部分是对象自有的实例数据。另一部分是对象所属的类型的数据，成为元数据. 元数据与实例数据并不是存放在同一个地方，元数据是存放在一个名为方法区的区域.
    * 对象实例内存的实现方式有2种
        * 对象实例本身并不存放数据，而是存放2个指针. 一个指针指向实例数据，另一个指针指向方法区中的元数据. 这种方式的缺点在于，由于实例数据是存放在堆上的，而堆上的垃圾回收是非常频繁的，而一旦发生垃圾回收，就会导致数据的地址改变，这样就会导致指针的频繁变更. 方法区的垃圾回收的频率是比较低的.
        * 对象实例本书存放实例数据和一个指针，指针就指向方法区中的元数据.
* Java对象创建的过程
    * new关键字创建对象的3个步骤
        * 在堆内存中创建出对象的实例. 分为2种情况
            1. 指针碰撞：当堆内存空间由一个指针分割，一侧为已占用空间，另一侧则是未必占用空间. 那么新创建的对象在未被占用空间中创建. 指针往未被占用空间移动. 这种情况叫做指针碰撞，这种情况下堆空间是连续的.
            2. 空闲列表：当堆内存空间中已使用空间和为使用空间交织在一起时，虚拟机就需要通过一个列表来记录哪些空间可以使用，以为哪些空间已经被使用. 在创建对象时需要在列表中找出哪些违背使用的空间可以容纳下新创建的对象，并且在存放对象之后，修改空闲列表. 这种情况内存空间是不连续的，通常是由于某些虚拟机在垃圾回收后没有进行空间压缩造成的.
        * 为对象的实例变量赋初值
        * 返回对象的引用
    * 对象在内存中的布局
        * 对象头
        * 实例数据（即在类中所声明的各项信息）
        * 对齐填充（可选）

 */
public class Test1 {
    public static void main(String[] args) {
        List<Test1> list = new ArrayList<>();
        for (;;){
            list.add(new Test1());
        }
    }
}
