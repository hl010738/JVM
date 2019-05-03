package classloader;

/*
   类继承的初始化

   在类的继承关系中，通过子类访问父类的静态成员并不属于对子类的主动使用
   而是对父类的主动使用
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(Child11.a);
        System.out.println("------------");
        Child11.doSomething();
    }
}

class Parent11{
    static int a = 3;
    static {
        System.out.println("Parent11 static block");
    }
    static void doSomething(){
        System.out.println("do something");
    }
}

class Child11 extends Parent11{
    static {
        System.out.println("Child11 static block");
    }
}