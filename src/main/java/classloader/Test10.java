package classloader;


/*
    类继承的初始化
 */

public class Test10 {
    static {
        System.out.println("Test10 static block");
    }

    public static void main(String[] args) {

        //声明一个对象的引用不是对一个类的主动使用
        Parent10 parent10;
        System.out.println("---------");
        parent10 = new Parent10();
        System.out.println("-----------");
        System.out.println(Parent10.a);
        System.out.println("---------");
        System.out.println(Child10.b);
    }
}

class Parent10{
    static int a = 3;
    static {
        System.out.println("Parent10 static block");
    }
}

class Child10 extends Parent10{
    static int b = 4;
    static {
        System.out.println("Child10 static block");
    }
}
