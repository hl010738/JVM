package classloader;

/*
    类加载器
 */
public class Test7 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("classloader.C").getClassLoader());
        System.out.println(Class.forName("java.lang.String").getClassLoader());
    }
}

class C{

}