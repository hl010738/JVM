package classloader;

/*
    类加载器加载类的初始化

    1. 通过ClassLoader加载类不是对类的主动使用，不会对类进行初始化.
    2. 使用反射Class.forName()方法加载类是对类的主动使用.

 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass("classloader.CL");
        System.out.println("-----------");
        Class.forName("classloader.CL");
    }
}

class CL{
    static {
        System.out.println("CL static block");
    }
}