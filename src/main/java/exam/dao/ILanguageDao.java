package exam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public interface ILanguageDao {

    public List getLanguage(Connection conn) throws SQLException;

}
