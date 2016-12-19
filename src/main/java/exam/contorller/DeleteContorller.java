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

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
@WebServlet(name = "DeleteContorller", value = "/deleteContorller")
public class DeleteContorller extends HttpServlet {

    private IFilmService filmService = new FileServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;

        String film_id = request.getParameter("film_id");
        System.out.println(film_id);
        filmService.deleteFile(Integer.valueOf(film_id));
        rd = request.getRequestDispatcher("/indexContorller");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
