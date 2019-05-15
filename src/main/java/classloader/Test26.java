package classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/*
     线程上下文类加载器的一般使用逻辑：获取 — 使用 — 还原

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try{
                Thread.currentThread().setContextClassLoader(targetClassLoader);
                doSomething(); // 在这个方法里获取当前线程的上下文类加载器完成业务逻辑.
        } finally {
                Thread.currentThread().setContextClassLoader(classLoader);
        }

   线程上下文类加载器，使用ServiceLoader加载器mysql 驱动
 */
public class Test26 {
    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> it = loader.iterator();

        while (it.hasNext()){
            Driver driver = it.next();

            System.out.println("Driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("ContextClassLoader: " + Thread.currentThread().getContextClassLoader());
        System.out.println("SerivceLoader class loader: " + ServiceLoader.class.getClassLoader());
    }
}
