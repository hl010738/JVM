package classloader;

/*
    加载器的层次结构
 */

public class Test13 {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        System.out.println("---------");

        while (null != cl){
            cl = cl.getParent();
            System.out.println(cl);
        }

    }
}
