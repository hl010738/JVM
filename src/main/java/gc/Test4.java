package gc;

/*
82_实例演示MaxTenuringThreshold参数及阈值动态调整策略
    -verbose:gc
    -Xmx200m
    -Xmn50m
    -XX:TargetSurvivorRatio=60
    -XX:+PrintGCDetails
    -XX:MaxTenuringThreshold=5
    -XX:+PrintTenuringDistribution
    -XX:+PrintGCDateStamps
    -XX:+UseConcMarkSweepGC
    -XX:+UseParNewGC
    -XX:MaxTenuringThreshold=3
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes1 = new byte[512 * 1024];
        byte[] bytes2 = new byte[512 * 1024];

        myGC();
        Thread.sleep(1000);

        System.out.println("111111");

        myGC();
        Thread.sleep(1000);

        System.out.println("22222222");

        myGC();
        Thread.sleep(1000);

        System.out.println("33333333");

        myGC();
        Thread.sleep(1000);

        System.out.println("4444444");

        byte[] bytes3 = new byte[1024 * 1024];
        byte[] bytes4 = new byte[1024 * 1024];
        byte[] bytes5 = new byte[1024 * 1024];

        myGC();
        Thread.sleep(1000);

        System.out.println("55555555");

        myGC();
        Thread.sleep(1000);

        System.out.println("66666666");

        System.out.println("-------------");

    }

    private static void myGC(){
        for (int i = 0; i <40; i++){
            byte[] bytes = new byte[1024 * 1024];
        }
    }
}
