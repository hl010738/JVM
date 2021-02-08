package reference;


import java.lang.ref.SoftReference;
import java.util.Date;

/*

			* Active：新创建的的引用实例都是Active状态.
			* Pending：未被注册到引用队列中的对象不可能处于该状态之下.
			* Enqueued：未被注册到引用队列中的对象不可能处于该状态之下.
			* Inactive：无法对改状态下的对象执行任何操作，处于该状态下的对象状态不会在发生任何变化.

 */
public class Test1 {

    public static void main(String[] args) {
        Date date = new Date();

        SoftReference<Date> dateSoftReference = new SoftReference<>(date);

        Date date1 = dateSoftReference.get();

        if (null != date1){
            System.out.println("aaa");
        } else {
            System.out.println("bbb");
        }

        System.out.println("===================");

        dateSoftReference.clear();

        Date date2 = dateSoftReference.get();
    }
}
