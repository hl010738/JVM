package bytecode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test9 {
    public static void main(String[] args) {

        Interface9Impl obj = new Interface9Impl();
        InvocationHandler dynamicProxy = new DynamicProxy(obj);

        Class<?> cls = obj.getClass();

        Interface9 interface9 = (Interface9) Proxy.
                newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), dynamicProxy);

        interface9.request();

    }
}

class DynamicProxy implements InvocationHandler{

    private Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy invoked start..." + method.getName());

        method.invoke(obj, args);

        System.out.println("Proxy invoked end..." + method.getName());
        return null;
    }
}