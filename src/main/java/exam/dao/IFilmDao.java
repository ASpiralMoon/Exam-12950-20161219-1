package exam.dao;

import exam.entity.Customer;
import exam.entity.Film;
import exam.entity.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public interface IFilmDao {

    public void insert(Connection conn, Film f) throws SQLException;

    public void delete(Connection conn, int film_id) throws SQLException;

    public void update(Connection conn, Film f) throws SQLException;

    public List getById(Connection conn, int film_id) throws SQLException;

    public List getAll(Connection conn) throws SQLException;
}
