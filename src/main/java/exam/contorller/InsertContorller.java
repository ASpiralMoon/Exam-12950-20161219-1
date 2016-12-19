package exam.contorller;

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
@WebServlet(name = "InsertContorller", value = "/insertContorller")
public class InsertContorller extends HttpServlet {

    private IFilmService filmService = new FileServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/Login/index.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
