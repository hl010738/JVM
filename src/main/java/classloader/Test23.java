package classloader;

import sun.misc.Launcher;

/*
    在运行期，一个Java类是由该类的完全限定名(Binary name，二进制名)和用于加载该类的定义类加载器(define loader)所共同决定的.
    如果同样名字(即相同的完全限定名)的类是由两个不同的加载器所加载，那么这些类就是不同的，即使.class文件的字节码和加载位置完全一样.

    在Oracle的HotSpot虚拟机实现中，系统属性sun.boot.class.path属性如果修改错误，则会运行出错，出错提示为：
    Error occured during initialization of VM java.lang.NoClassDefFoundError: java/lang/Object.

 */
public class Test23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println("-------------");
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println("-------------");
        //Launcher类也是启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());

        /*
         * 内建于JVM中的启动类加载器会加载java.lang.Object类以及其他Java平台类，当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器和系统类加载器，这块特殊的机器码就是启动类加载器(Boostrap classloader).
         * 启动类加载器不是Java类，它是由C++编写的，而其他的加载器则是Java类. 因此在rt.jar中没有启动类加载器(Boostrap)的，但是可以找到ExtClassLoader和AppClassLoader. 这就可以解释了为什么打印Object类ClassLoader是null.
         * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程. 所有的类加载器(除了启动类的加载器之外)都被实现为Java类. 但是总归是要有一个组件来加载第一个Java类加载器，从而能够Kick start整个加载过程. 加载第一个Java类加载器的就是启动类加载器.
         * 启动类加载器还会负责加载供JRE正常运行所需要的基本组件，包括java.util和java.lang包中的类等.
         */

        System.out.println("--------------");
        // 这个系统属性是定义默认的系统类加载器
        // 这个属性默认是没有定义的
        System.out.println(System.getProperty("java.system.class.loader"));
    }
}
