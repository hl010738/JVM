package classloader;

/*
    类加载器的命名空间 类里面引用了其他类
 */

public class Test17_1 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/talent/Desktop/");
        Class<?> class1 = loader1.loadClass("classloader.Sample2");

        System.out.println("class: " + class1.hashCode());

        //如果注释掉这行，那么并不会实例化Sample1以及Sample2
        //即Sample2的构造方法不会被调用.
        //Sample1也没有主动使用，因此不会加载Sample1
        Object obj = class1.newInstance();
    }
}
