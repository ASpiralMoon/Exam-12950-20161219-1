package exam.contorller;

import exam.entity.Film;
import exam.entity.Language;
import exam.service.IFilmService;
import exam.service.ILanguagesService;
import exam.service.impl.FileServiceImpl;
import exam.service.impl.LanguagesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
@WebServlet(name = "GetContorller", value = "/getContorller")
public class GetContorller extends HttpServlet {

    private IFilmService filmService = new FileServiceImpl();
    private ILanguagesService languagesService = new LanguagesServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;

        String film_id = request.getParameter("film_id");
        System.out.println(film_id);
        List list1 = filmService.getFileById(Integer.valueOf(film_id));
        System.out.println(list1.size());
        System.out.println(list1.get(0));
        List list2 = languagesService.getLanguages();
        System.out.println(list2.size());
        list1.add(list2);
        System.out.println(list1);
        request.setAttribute("data1", list1);
        rd = request.getRequestDispatcher("/Login/edit.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
