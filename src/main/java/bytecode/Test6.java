package bytecode;
/*
    方法重写 动态分派

* 方法重写字节码分析
    * 在静态的源代码字节码分析中可以看到，在父类的引用指向子类实例的情况下，方法调用还是父类的方法. 并不是在编译器就确定调用哪个子类的方法，具体调用的是哪个子类的方法是在运行期决定的.
    * 方法的动态分派涉及到一个重要的概念：方法接收者.
    * invokevirtual字节码指令的多态查找流程.
        * 到操作数的栈顶寻找栈顶元素所指向的实际类型.
        * 如果在类型当中寻找到了与常量池当中描述符和名称都相同的方法，并具有响应的访问权限，就返回该方法的直接引用，然后过程结束.
        * 如果找不到，就按照从子类到父类的顺序依次查找，直到找到匹配的方法.
        * 如果一直都找不到，抛出异常.
    * 方法重写属于动态分派.
* 方法重写和方法重载的比较
    * 方法重载是静态的，编译期的行为
    * 方法重写是动态的，运行期的行为
    * 区分静态和动态的方法，是看方法调用者，如果方法调用者是相同的，那么就是静态的，虽然参数不同. 而调用者不同的，那么就是动态的.

 */
public class Test6 {
    public static void main(String[] args) {
        A a1 = new AA();
        A a2 = new AAA();

        a1.test();
        a2.test();

        a1 = new AAA();
        a1.test();
    }

}

class A{
   public void test(){
       System.out.println("A");
   }
}
class AA extends A{
    @Override
    public void test(){
        System.out.println("AA");
    }
}

class AAA extends A{
    @Override
    public void test(){
        System.out.println("AAA");
    }
}