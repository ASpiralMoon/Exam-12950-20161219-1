package exam.contorller;

import exam.entity.Customer;
import exam.service.ICheckCustomerService;
import exam.service.impl.CheckCustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 * 登录校验
 */
@WebServlet(name = "LoginContorller", value = "/loginContorller")
public class LoginContorller extends HttpServlet {

    private ICheckCustomerService checkCustomerService = new CheckCustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");

        System.out.println("用户名: " + userName);

        RequestDispatcher rd = null;

        Customer c = new Customer();
        c.setFirst_name(userName);
        boolean b = checkCustomerService.checkCustomer(c);
        if (b) {
            request.getSession().setAttribute("flag", "login_success");
            rd = request.getRequestDispatcher("/indexContorller");
            rd.forward(request, response);

        } else {
            request.getSession().setAttribute("flag", "login_error");
            request.setAttribute("msg", "用户名或密码错误");
            rd = request.getRequestDispatcher("/Login/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
