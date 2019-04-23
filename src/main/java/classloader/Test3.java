package classloader;

import java.util.UUID;

/*
    当常量的值在编译器不能确定时，那么他的值就不会被放到调用类的常量池中.
    这样在程序运行时，会导致程序主动使用常量所在的类，这样就会导致这个类初始化.
 */

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }
}

class Parent3{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Parent3 static block");
    }
}
