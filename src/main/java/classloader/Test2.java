package classloader;

// 常量在编译阶段会存入到调用这个常量的方法所在类的常量池中
// 本质上，调用类并没有引用到常量所在的类，因此不会触发常量所在类的初始化

// 这里常量str是存入到Test2的常量池中，此后Test2和Parent2再无联系
// 甚至，可以将Paren2的class文件删除之后，还是可以正常运行.

/*
    助记符：
        ldc：将int，float或者String类型的常量值从常量池中推送至栈顶.
        bipush：将单字节( -128 ~ 127 ) 的常量值从常量池中推送至栈顶.
        sipush：将一个短整型常量( -32768 ~ 32767) 从常量池中推送至栈顶.
        iconst_1：将int类型 1 推送至栈顶. 范围是 iconst_1 ~ iconst_5，从6开始会变为bipush.
 */

public class Test2 {
    public static void main(String[] args) {
        //并不会触发初始化
        System.out.println(Parent2.str);
    }
}

class Parent2{
    // 在反编译Test2文件中，此变量会出现在Test2的class文件中
    public static final String str = "qqq";

    static {
        System.out.println("Parent2 static block");
    }
}
