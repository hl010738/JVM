package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
    自定义类加载器
 */

public class Test16 {
    public static void main(String[] args) throws Exception {

        Test16 test16 = new Test16();
        //test16.testLoader();
        test16.testUnload();

    }

    // 类的卸载的示例方法
    private void testUnload() throws Exception {

        MyClassLoader loader1 = new MyClassLoader("loader1");
        // 设置一个不在工程目录下的path
        loader1.setPath("/Users/talent/Desktop/");
        Class<?> class1 = loader1.loadClass("classloader.Test1");

        Object obj = class1.newInstance();
        System.out.println(obj.getClass().getClassLoader());

        System.out.println("=====================");

        loader1 = null;
        class1 = null;
        obj = null;

        // -XX:+TraceClassUnloading 使用这个参数可以打印类卸载信息.
        System.gc();

        // 指向新的对象
        loader1 = new MyClassLoader("loader1");
        // 设置一个不在工程目录下的path
        loader1.setPath("/Users/talent/Desktop/");
        class1 = loader1.loadClass("classloader.Test1");

        obj = class1.newInstance();
        System.out.println(obj.getClass().getClassLoader());
    }

    // 类加载的示例方法
    private void testLoader() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        //cl.setPath("/Users/talent/Desktop/intelliJ/JVM/build/classes/java/main/classloader/");

        // 设置一个不在工程目录下的path
        loader1.setPath("/Users/talent/Desktop/");

        // 如果需要使用自定义的类加载器需要将工程下的Test1删除
        // 系统类加载器AppClassLoader首先会在工程目录下查找Test1
        // 一旦找到就会直接加载，因此指定的Test1是不会被加载的
        Class<?> class1 = loader1.loadClass("classloader.Test1");

        Object obj = class1.newInstance();
        System.out.println(obj.getClass().getClassLoader());

        System.out.println("=====================");

        //ClassLoader16 loader2 = new ClassLoader16("loader2");

        // 这种情况下，loader1 作为 loader2 的父加载器去加载Test1 class
        // 但是之前Test1 已经被loader1 加载过，因此 loader2 加载时会直接返回
        // findClass方法不会被调用.
        MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
        loader2.setPath("/Users/talent/Desktop/");

        Class<?> class2 = loader2.loadClass("classloader.Test1");
        Object obj2 = class2.newInstance();
        System.out.println(obj2.getClass().getClassLoader());

        System.out.println("=====================");

        MyClassLoader loader3 = new MyClassLoader(loader2,"loader3");
        loader3.setPath("/Users/talent/Desktop/");

        Class<?> class3 = loader3.loadClass("classloader.Test1");
        Object obj3 = class3.newInstance();
        System.out.println(obj3.getClass().getClassLoader());
    }
}

