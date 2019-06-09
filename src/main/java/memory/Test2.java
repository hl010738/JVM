package memory;

/*
    虚拟机栈 溢出 stack over flow
 */
public class Test2 {
    private int length;

    public int getLength(){
        return length;
    }

    public void test(){
        this.length++;

        try {
            Thread.sleep(300);
        } catch (Exception e){

        }

        test();
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        try {
            t.test();
        } catch (Throwable e){
            System.out.println("------" + t.getLength());
            e.printStackTrace();
        }
    }
}
