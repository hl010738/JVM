package classloader;

import java.lang.reflect.Method;

/*
    类加载 反射
 */
public class Test20 {
    public static void main(String[] args) throws Exception{
        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");

        Class<?> class1 = loader1.loadClass("classloader.Person");
        Class<?> class2 = loader2.loadClass("classloader.Person");

        // 两个加载器都会委托appclassloader 加载
        System.out.println(class1 == class2); //true

        Object obj1 = class1.newInstance();
        Object obj2 = class2.newInstance();

        Method method = class1.getMethod("setPerson", Object.class);

        method.invoke(obj1, obj2);
    }
}