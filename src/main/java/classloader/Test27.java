package classloader;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Test27 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection connection = DriverManager.getDrivers();
        Connection connection = null;
        System.out.println(connection.getClass().getClassLoader());
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()){
            System.out.println(drivers.nextElement().getClass().getClassLoader());
        }
    }
}
