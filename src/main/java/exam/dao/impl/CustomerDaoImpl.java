package exam.dao.impl;

import exam.dao.ICustomerDao;
import exam.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class CustomerDaoImpl implements ICustomerDao {

    /**
     * 根据指定first_name查询用户
     * @param conn
     * @param c
     * @return
     */
    @Override
    public ResultSet get(Connection conn, Customer c) throws SQLException {
        String selectSql = "select customer_id, first_name from customer where first_name = ?";
        PreparedStatement ps = conn.prepareCall(selectSql);
        ps.setString(1,c.getFirst_name());
        System.err.println("done");
        return ps.executeQuery();
    }
}
