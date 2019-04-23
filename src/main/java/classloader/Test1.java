package classloader;

/*
    对于静态字段来说，只有直接定义了该字段的类才会被初始化
    当一个类在初始化时，要求其父类全部初始化完毕.
    -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来.
 */
public class Test1 {
    public static void main(String[] args) {

        //当只有这句代码时，由于只访问了父类的变量
        //因此只有父类被初始化
        System.out.println(MyChild1.string);

        System.out.println("------------");

        //当只有这局代码时，访问了子类的变量
        //子类以及父类都会被初始化
        System.out.println(MyChild1.str);
    }
}

class MyParent1{
    public static String string = "hello world";
    static {
        System.out.println("MyParent1");
    }
}

class MyChild1 extends MyParent1{
    public static String str = "1111";
    static {
        System.out.println("MyChild1");
    }
}
