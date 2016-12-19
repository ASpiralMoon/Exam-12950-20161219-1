package exam.dao.impl;

import exam.dao.ILanguageDao;
import exam.entity.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 * 获得电影演员
 */
public class LanguageDaoImpl implements ILanguageDao {

    @Override
    public List<Language> getLanguage(Connection conn) throws SQLException {
        String selectSql = "select language_id,name from language";
        PreparedStatement ps = conn.prepareCall(selectSql);
        List<Language> list = new ArrayList<>();
        Language language = null;
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            language = new Language();
            language.setLanguage_id(resultSet.getShort("language_id"));
            language.setName(resultSet.getString("name"));
            list.add(language);
    }
        return list;
    }
}
