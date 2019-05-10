package classloader;

import java.lang.reflect.Method;

/*
    类加载器 反射
 */
public class Test21 {
    public static void main(String[] args) throws Exception{
        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");

        loader1.setPath("/Users/talent/Desktop/");
        loader2.setPath("/Users/talent/Desktop/");

        Class<?> class1 = loader1.loadClass("classloader.Person");
        Class<?> class2 = loader2.loadClass("classloader.Person");

        // 不同命名空间下的类不可见.
        System.out.println(class1 == class2); //false

        Object obj1 = class1.newInstance();
        Object obj2 = class2.newInstance();

        Method method = class1.getMethod("setPerson", Object.class);

        method.invoke(obj1, obj2);
    }
}
