package exam.service.impl;

import exam.dao.ICustomerDao;
import exam.dao.impl.CustomerDaoImpl;
import exam.entity.Customer;
import exam.jdbc.ConnectionFactory;
import exam.service.ICheckCustomerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class CheckCustomerServiceImpl implements ICheckCustomerService {

    private ICustomerDao customerDao = new CustomerDaoImpl();

    public boolean checkCustomer(Customer c) {

        Connection conn = null;

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet resultSet = customerDao.get(conn, c);

            while (resultSet.next())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
