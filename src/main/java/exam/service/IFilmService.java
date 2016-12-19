package exam.service;

import exam.entity.Film;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public interface IFilmService {

    public void insertFilm(Film f);

    public void deleteFile(int film_id);

    public void updateFile(Film f);

    public List<Film> getFileById(int film_id);

    public List getAll();

}
