package exam.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by ASpiralMoon on 2016/12/19.
 *  JDBC工厂类
 */
public class ConnectionFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private static final ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    static {

        Properties prop = new Properties();

        try {
            InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("exam/dbconfig.properties");
            System.out.println(is);
            prop.load(is);
        } catch (IOException e) {
            System.out.println("配置文件读取错误");
            e.printStackTrace();
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");

    }

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        return factory;
    }

    public Connection makeConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
