package jdbc;

import exam.jdbc.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class ConnectionFactoryTest {

    @Test
    public void test() throws SQLException {

        ConnectionFactory cf = ConnectionFactory.getInstance();

        Connection conn = cf.makeConnection();

        System.out.println(conn.getAutoCommit());

    }
}
