package service;

import exam.dao.IFilmDao;
import exam.dao.impl.FilmDaoImpl;
import exam.entity.Film;
import exam.jdbc.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class TestGetById {

    private IFilmDao iFilmDao = new FilmDaoImpl();
    Connection conn = null;

    @Test
    public void test() {

        List<Film> list = new ArrayList<>();

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            list = iFilmDao.getById(conn, 1003);
            System.out.println(list.size());

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
