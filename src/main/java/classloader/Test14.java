package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/*
    使用类加载器加载类
 */

public class Test14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resource = "classloader/Test13.class";

        Enumeration<URL> urls = classLoader.getResources(resource);

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("-------------");

        Class clazz = Test14.class;
        classLoader = clazz.getClassLoader();
        System.out.println(classLoader);

    }
}
