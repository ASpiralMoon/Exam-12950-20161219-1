package exam.dao;

import exam.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public interface ICustomerDao {

    public ResultSet get(Connection conn, Customer c) throws SQLException;

}
