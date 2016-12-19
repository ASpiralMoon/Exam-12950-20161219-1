package service;

import exam.dao.IFilmDao;
import exam.dao.impl.FilmDaoImpl;
import exam.entity.Film;
import exam.jdbc.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class TestDelete {

    private IFilmDao iFilmDao = new FilmDaoImpl();
    Connection conn = null;

    @Test
   public void test() {
       try {

           conn = ConnectionFactory.getInstance().makeConnection();
           conn.setAutoCommit(false);
           iFilmDao.delete(conn, 998);

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
   }

}
