package exam.contorller;

import exam.entity.Film;
import exam.service.IFilmService;
import exam.service.impl.FileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
@WebServlet(name = "EditContorller", value = "/editContorller")
public class EditContorller extends HttpServlet {

    private IFilmService filmService = new FileServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        RequestDispatcher rd = null;
//
//        String film_id = request.getParameter("film_id");
//        System.out.println(film_id);
//        List<Film> list = filmService.getFileById(Integer.valueOf(film_id));
//        request.setAttribute("data", list);
//        rd = request.getRequestDispatcher("/Login/edit.jsp");
//        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
