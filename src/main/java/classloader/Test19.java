package classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/*
    扩展类加载器信息
 */
public class Test19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(Test19.class.getClassLoader());
    }
}
