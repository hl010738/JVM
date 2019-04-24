package classloader;

/*
    类加载的准备阶段例子
 */
public class Test6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.c1);
        System.out.println(Singleton.c2);
    }
}

// 初始化顺序从上到下依次执行
class Singleton{
    public static int c1;
    // 如果这行代码放在构造方法之前
    // 打印结果为：1 1
    //public static int c2 = 0;
    private static Singleton singleton = new Singleton();

    private Singleton(){
        c1++;
        c2++;

        // 在初始化之前的准备阶段
        // 两个变量都会被赋予默认值0
        // 并且自加，因此都为1
        System.out.println("--------" + c1);
        System.out.println("---------" + c2);
    }

    // 如果这行代码放在构造方法之后
    // 打印结果为：1 0
    // 准备阶段结束后进行初始化
    // 显式地将0覆盖给c2，因此值为0
    public static int c2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }
}
