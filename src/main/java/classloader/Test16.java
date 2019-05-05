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
        ClassLoader16 cl = new ClassLoader16("classLoader");
        test(cl);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("classloader.Test1");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}

class ClassLoader16 extends ClassLoader{
    private String classLoaderName;

    private final String extension = ".class";

    public ClassLoader16(String classLoaderName){
        super(); // 默认将系统类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    public ClassLoader16(ClassLoader parent, String classLoaderName){
        super(parent); // 显式指定父加载器
        this.classLoaderName = classLoaderName;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    @Override
    public String toString(){
        return "--" + this. classLoaderName + "--";
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(name + this.extension));
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
