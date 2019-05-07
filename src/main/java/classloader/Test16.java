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
        ClassLoader16 loader1 = new ClassLoader16("loader1");
        //cl.setPath("/Users/talent/Desktop/intelliJ/JVM/build/classes/java/main/classloader/");

        // 设置一个不在工程目录下的path
        loader1.setPath("/Users/talent/Desktop/");

        // 如果需要使用自定义的类加载器需要将工程下的Test1删除
        // 系统类加载器AppClassLoader首先会在工程目录下查找Test1
        // 一旦找到就会直接加载，因此指定的Test1是不会被加载的
        Class<?> class1 = loader1.loadClass("classloader.Test1");

        System.out.println("---------");
        Object obj = class1.newInstance();
        System.out.println(obj.getClass().getClassLoader());

        System.out.println("=====================");

        //ClassLoader16 loader2 = new ClassLoader16("loader2");

        // 这种情况下，loader1 作为 loader2 的父加载器去加载Test1 class
        // 但是之前Test1 已经被loader1 加载过，因此 loader2 加载时会直接返回
        // findClass方法不会被调用.
        ClassLoader16 loader2 = new ClassLoader16(loader1,"loader2");
        loader2.setPath("/Users/talent/Desktop/");

        Class<?> class2 = loader2.loadClass("classloader.Test1");
        System.out.println("---------");
        Object obj2 = class2.newInstance();
        System.out.println(obj2.getClass().getClassLoader());

        System.out.println("=====================");

        ClassLoader16 loader3 = new ClassLoader16(loader2,"loader3");
        loader3.setPath("/Users/talent/Desktop/");

        Class<?> class3 = loader3.loadClass("classloader.Test1");
        System.out.println("---------");
        Object obj3 = class3.newInstance();
        System.out.println(obj3.getClass().getClassLoader());

    }
}

class ClassLoader16 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private final String extension = ".class";

    public ClassLoader16(String classLoaderName){
        super(); // 默认将系统类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    public ClassLoader16(ClassLoader parent, String classLoaderName){
        super(parent); // 显式指定父加载器
        this.classLoaderName = classLoaderName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("findClass invoked: " + name);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        name = name.replace(".", "/");

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(this.path + name + this.extension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}
