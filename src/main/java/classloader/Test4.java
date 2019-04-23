package classloader;

/*
    对于数组实例来说，其类型时由JVM运行时动态生成的，表示为 "左方括号L类型全名;" 的形式. 例如一维数组：[Ljava.lang.String;  二维数组 [[Ljave.lang.String; 动态生成的类型其父类型就是Object.
    对于数组来说，javadoc经常将构成数组的元素成为Component. 实际上就是数组降低一个维度后的类型.

    助记符：
        anewarray：表示创建一个引用类型(如类，接口，数组等)的数组，并将其引用值压入栈顶
        newarray：表示创建一个原始类型(如int，float等)的数组，并将其引用值压入栈顶.

 */
public class Test4 {
    public static void main(String[] args) {

        // 创建数组实例不会触发代码代码块
        // 运行期系统会创建一个数组类型的实例
        Parent4[] ps = new Parent4[1];
        System.out.println(ps.getClass());

        System.out.println("--------------");

        Parent4[][] pss = new Parent4[1][1];
        System.out.println(pss.getClass());
    }
}

class Parent4{
    static {
        System.out.println("Parent4 static block");
    }
}
