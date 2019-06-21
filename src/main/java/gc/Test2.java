package gc;

/*
    对象分配实例分析
    -verbose:gc
    -Xms20m
    -Xmx20m
    -Xmn10m
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=4194304
    -XX:+UseSerialGC
 */
public class Test2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] malloc = new byte[10 * size];
    }
}
