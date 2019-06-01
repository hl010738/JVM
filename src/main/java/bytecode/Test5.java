package bytecode;

public class Test5 {
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
        Grandpa g1 = new Grandpa();
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