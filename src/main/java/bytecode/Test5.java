package bytecode;

/*
    方法的静态分派

    Grandpa g1 = new Father();

    以上代码 g1 的静态类型时Grandpa，而g1的实际类型（真正指向的类型）是Father

    结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），实际类型时运行期方可确定。

 */
public class Test5 {
    // 方法重载 是一种静态行为，在编译器就可以确定
    public void test(Grandpa grandpa){
        System.out.println("Grandpa");
    }
    public void test(Father father){
        System.out.println("Father");
    }
    public void test(Son son){
        System.out.println("Son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Test5 t = new Test5();

        t.test(g1);
        t.test(g2);
    }
}

class Grandpa{
}

class Father extends Grandpa{

}
class Son extends Father{

}