package classloader;

/*
   类继承的初始化
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