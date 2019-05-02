package classloader;

import javax.swing.*;

/*
    当一个接口在初始化时并要求其父接口也完成初始化.
    当一个接口在初始化时并要求其父接口也完成初始化. 只有在真正使用父接口时(如引用接口所定义的常量时)，才会进行初始化.
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}

interface Grandpa5{
    public static Thread thread = new Thread(){
        {
        System.out.println("Grandpa5");
        }
    };
}

interface Parent5 extends Grandpa5{
    public static Thread thread = new Thread(){
        {
            System.out.println("Parent5");
        }
    };
}

class Grandson5 implements Parent5{
    public static Thread thread = new Thread(){
        {
            System.out.println("GrandSon5");
        }
    };
}

class Child5 extends Grandson5 implements Parent5{
    public static int b = 6;
}
