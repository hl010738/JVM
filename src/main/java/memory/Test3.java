package memory;

/*
    jvisualvm 工具 和 jsonsole 工具 查看死锁

    2个线程锁定 形成死锁
 */
public class Test3 {
    public static void main(String[] args) {
        new Thread(() -> A3.test(), "Thread A3").start();
        new Thread(() -> B3.test(), "Thread B3").start();
    }
}

class A3{
    public static synchronized void test(){
        System.out.println("From A3");

        try {
            Thread.sleep(3000);
            B3.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B3{
    public static synchronized void test(){
        System.out.println("From B3");

        try {
            Thread.sleep(3000);
            A3.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}