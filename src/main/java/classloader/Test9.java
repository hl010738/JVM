package classloader;

/*
    类继承的初始化
 */

public class Test9 {
    static {
        System.out.println("Test9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child9.b);
    }
}

class Parent9{
    static int a = 3;

    static {
        System.out.println("Parent9 static block");
    }
}

class Child9 extends Parent9{
    static int b = 4;
    static {
        System.out.println("Child9 static block");
    }
}