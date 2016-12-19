package exam.service.impl;

import exam.dao.IFilmDao;
import exam.dao.impl.FilmDaoImpl;
import exam.entity.Film;
import exam.jdbc.ConnectionFactory;
import exam.service.IFilmService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class FileServiceImpl implements IFilmService {

    private IFilmDao iFilmDao = new FilmDaoImpl();
    Connection conn = null;

    /**
     * 添加电影条目
     *
     * @param f
     */
    @Override
    public void insertFilm(Film f) {
        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            iFilmDao.insert(conn, f);

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

    /**
     * 单条删除电影
     *
     * @param film_id
     */
    @Override
    public void deleteFile(int film_id) {
        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            iFilmDao.delete(conn, film_id);

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

    /**
     * 单条更新电影
     *
     * @param f
     */
    @Override
    public void updateFile(Film f) {
        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            iFilmDao.update(conn, f);

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

    /**
     * 获得单条电影
     * @param film_id
     * @return
     */
    @Override
    public List<Film> getFileById(int film_id) {

        List<Film> list = new ArrayList<>();

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            list = iFilmDao.getById(conn, film_id);

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
        return list;
    }

    @Override
    public List getAll() {

        List list = null;

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            list = iFilmDao.getAll(conn);

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
        return list;
    }
}
