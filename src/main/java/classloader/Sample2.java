package classloader;

public class Sample2 {
    public Sample2() {
        System.out.println("Sample2 loaded by: " + this.getClass().getClassLoader());
        new Sample1();
        System.out.println("From Sample2: " + Sample1.class);
    }
}
