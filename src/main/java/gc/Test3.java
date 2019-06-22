package gc;

/*
    -verbose:gc
    -Xms20m
    -Xmx20m
    -Xmn10m
    -XX:+PrintGCDetails
    -XX:+PrintCommandLineFlags
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=4194304
    -XX:MaxTenuringThreshold=5
    -XX:+PrintTenuringDistribution
 */
public class Test3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] malloc1 = new byte[2 * size];
        byte[] malloc2 = new byte[2 * size];
        byte[] malloc3 = new byte[2 * size];
        byte[] malloc4 = new byte[2 * size];

        System.out.println("---------");
    }
}
