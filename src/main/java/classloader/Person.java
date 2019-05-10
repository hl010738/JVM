package classloader;

public class Person {
    private classloader.Person person;

    public void setPerson(Object object) {
        this.person = (classloader.Person) object;
    }
}
