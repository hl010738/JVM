package bytecode;

/*
    字节码分析 使用jclasslib插件查看字节码
 */
public class Test1 {
    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
