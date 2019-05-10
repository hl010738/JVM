package classloader;

import java.lang.reflect.Method;

/*
    类加载器 反射

  类加载器的双亲委托模型的好处：
    1. 可以确保Java核心库的类型安全：所有的Java应用都至少会引用java.lang.Object类，
       也就是说在运行期，java.lang.Object类会被加载到Java虚拟机中.
       如果这个过程是由应用也就是自定义的类加载器所完成的，那么很可能会在JVM中存在多个版本的java.lang.Object类，并且这些类之间都是不兼容，不可见的(正是命名空间发挥作用).
       借助双亲委托机制，Java核心类库中的类的加载工作都是由启动类加载器同意完成，这样就确保了应用所使用的核心类库都是同一版本的类库，他们是互相兼容的.
    2. 可以确保Java核心类库所提供的类不会被自定义的类所替代.
    3. 不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间。
       相同名称的类可以并存在Java虚拟机中，只需要用不同的类加载器加载他们即可.
       不同类加载器(没有父子委托关系)所加载类是不兼容的，这就相当于在Java虚拟机内部创建了多个相互隔离的Java类空间，这类技术在很多框架中都得到了实际应用.

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
