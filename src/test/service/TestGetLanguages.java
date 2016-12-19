package service;

import exam.dao.ILanguageDao;
import exam.dao.impl.LanguageDaoImpl;
import exam.entity.Language;
import exam.jdbc.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
public class TestGetLanguages {

    private ILanguageDao iLanguageDao = new LanguageDaoImpl();
    Connection conn = null;

    @Test
    public void test() {
        List<Language> list = new ArrayList<>();

        try {

            conn = ConnectionFactory.getInstance().makeConnection();
            list = iLanguageDao.getLanguage(conn);
            System.out.println("list的长度: " + list.size());

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
