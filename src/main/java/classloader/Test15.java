package classloader;

/*
    数组的类加载器
 */
public class Test15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("-----------");

        int[] ints = {1,2,3};
        System.out.println(ints.getClass().getClassLoader());

        System.out.println("----------");

        AA[] aas = new AA[2];
        System.out.println(aas.getClass().getClassLoader());
    }
}

class AA{
}
