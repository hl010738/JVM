package classloader;


import java.sql.Connection;
import java.sql.DriverManager;

public class Test27 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("");
    }
}
