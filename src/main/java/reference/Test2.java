package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/*
    Reference Queue (引用队列) 的设计目的在于让我们能够知道或者识别出垃圾收集器所执行的动作
 */
public class Test2 {
    public static void main(String[] args) {

        Date date = new Date();

        ReferenceQueue<Date> referenceQueue = new ReferenceQueue();

        SoftReference<Date> dateSoftReference = new SoftReference<>(date, referenceQueue);

        System.out.println(dateSoftReference.get());
    }
}
