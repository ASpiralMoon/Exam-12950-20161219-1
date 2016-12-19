package exam.service.impl;

import exam.dao.ILanguageDao;
import exam.dao.impl.LanguageDaoImpl;
import exam.entity.Film;
import exam.entity.Language;
import exam.jdbc.ConnectionFactory;
import exam.service.ILanguagesService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class LanguagesServiceImpl implements ILanguagesService {

    private ILanguageDao iLanguageDao = new LanguageDaoImpl();
    Connection conn = null;

    /**
     * 获取语言
     *
     * @return
     */
    @Override
    public List<Language> getLanguages() {

        List<Language> list = new ArrayList<>();

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            list = iLanguageDao.getLanguage(conn);

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
