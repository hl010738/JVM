package classloader;

public class Sample1 {
    public Sample1() {
        System.out.println("Sample1 loaded by: " + this.getClass().getClassLoader());

        //System.out.println("From Sample1: " + Sample2.class);
    }
}
