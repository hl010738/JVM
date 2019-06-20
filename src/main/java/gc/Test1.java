package gc;

/*
    GC 日志分析

    加入JVM 参数：
        -verbose:gc
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails
        -XX:SurvivorRatio=8

 */

public class Test1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] malloc1 = new byte[2 * size];
        byte[] malloc2 = new byte[2 * size];
        byte[] malloc3 = new byte[2 * size];
        byte[] malloc4 = new byte[3 * size];

        System.out.println("---------");
    }
}
