package classloader;

public class Test22 {
    static {
        System.out.println("Test22 static invoke");
    }

    public static void main(String[] args) {
        //java -Djava.ext.dirs=./ classloader.Test22
        System.out.println(Test22.class.getClassLoader());
        System.out.println(Test1.class.getClassLoader());
    }
}
