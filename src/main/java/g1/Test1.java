package g1;

/*
    G1 日志分析

    -verbose:gc
    -Xms10m
    -Xmx10m
    -XX:+UseG1GC
    -XX:+PrintGCDetails
    -XX:+PrintGCDateStamps
    -XX:MaxGCPauseMillis=200m
 */
public class Test1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] malloc1 = new byte[2 * size];
        byte[] malloc2 = new byte[2 * size];
        //byte[] malloc3 = new byte[2 * size];
        //byte[] malloc4 = new byte[3 * size];

        System.out.println("---------");
    }
}
