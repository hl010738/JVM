package classloader;

import java.util.Random;

/*
    Final的初始化
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println(FinalClass.i);
    }
}

class FinalClass{

    // 静态代码不会执行
    public static final int i = 3;

    // 静态代码执行
    //public static int i = 3;

    // 静态代码执行
    //public static final int i =  new Random().nextInt();

    static {
        System.out.println("Static block");
    }
}