package memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/*
    方法区检测内存溢出错误
 */
public class Test4 {
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Test4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy) ->
                    proxy.invokeSuper(obj, args1));

            System.out.println("--------------");

            enhancer.create();
        }
    }
}
