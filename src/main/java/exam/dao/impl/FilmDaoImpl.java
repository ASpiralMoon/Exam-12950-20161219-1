package exam.dao.impl;

import exam.dao.IFilmDao;
import exam.entity.Film;
import exam.entity.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class FilmDaoImpl implements IFilmDao {

    /**
     * 保存电影信息
     *
     * @param conn
     * @param f
     */
    @Override
    public void insert(Connection conn, Film f) throws SQLException {
        String insertSql = "insert into film (title, description, language_id) value (?,?,?)";
        PreparedStatement ps = conn.prepareCall(insertSql);
        ps.setString(1, f.getTitle());
        ps.setString(2, f.getDescription());
        ps.setShort(3, f.getLanguage_id());
        ps.execute();
    }

    /**
     * 根据指定电影id删除电影信息
     *
     * @param conn
     * @param film_id
     */
    @Override
    public void delete(Connection conn, int film_id) throws SQLException {
        String deleteSql = "delete from film where film_id = ?";
        PreparedStatement ps = conn.prepareStatement(deleteSql);
        ps.setInt(1, film_id);
        System.out.println(film_id);
        ps.execute();
    }

    /**
     * 根据指定电影id编辑电影信息
     *
     * @param conn
     * @param f
     */
    @Override
    public void update(Connection conn, Film f) throws SQLException {
        String updateSql = "update film set title = ?, description = ?, language_id = ? where film_id = ?";
        PreparedStatement ps = conn.prepareCall(updateSql);
        ps.setString(1, f.getTitle());
        ps.setString(2, f.getDescription());
        ps.setShort(3, f.getLanguage_id());
        ps.setInt(4, f.getFilm_id());
        ps.execute();
    }

    /**
     * 根据指定电影id获取单条电影信息
     *
     * @param conn
     * @param film_id
     * @return
     * @throws SQLException
     */
    @Override
    public List getById(Connection conn, int film_id) throws SQLException {
        Film film = null;
        Language language = null;
        String selectSql = "select film_id,title, description,from film where film_id = ? ";
        PreparedStatement ps = conn.prepareCall(selectSql);
        ps.setInt(1, film_id);
        List<Film> list = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            film = new Film();
            language = new Language();
            film.setFilm_id(resultSet.getInt("film_id"));
            film.setTitle(resultSet.getString("title"));
            film.setDescription(resultSet.getString("description"));
            list.add(film);
        }
        return list;
    }

    /**
     * 获取全部电影信息
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    @Override
    public List<Film> getAll(Connection conn) throws SQLException {
        Film film = null;
        Language language = null;
        String selectAllSql = "SELECT film_id, title, description, name language from film f, language l " +
                "where f.language_id = l.language_id";
        PreparedStatement ps = conn.prepareCall(selectAllSql);
        List<Film> list = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            film = new Film();
            language = new Language();
            film.setFilm_id(resultSet.getInt("film_id"));
            film.setTitle(resultSet.getString("title"));
            film.setDescription(resultSet.getString("description"));
            language.setName(resultSet.getString("language"));
            film.setLanguage(language);
            list.add(film);
        }
        return list;
    }
}
