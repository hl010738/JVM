package bytecode;

import java.util.Date;

/*
 * 针对于方法动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table，vtable）.  即如果子类没有重写父类的方法，相当于直接继承了父类的方法，这样在子类虚方法表中会有一条记录指向父类虚方法表的中相应方法的位置，而不是将父类的方法copy到自身的虚方法表中.
 * 针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构（interface method table，itable）.
 */
public class Test7 {
    public static void main(String[] args) {
        B b = new B();
        B bb = new BB();

        b.test("111");
        bb.test(new Date());
    }
}

class B{
    public void test(String str){
        System.out.println("B String");
    }
    public void test(Date date){
        System.out.println("B Date");
    }
}

class BB extends B{
    @Override
    public void test(String str) {
        System.out.println("BB String");
    }

    @Override
    public void test(Date date) {
        System.out.println("BB Date");
    }
}