package exam.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ASpiralMoon on 2016/12/19.
 */
@WebFilter(filterName = "LoginFilter",value = "/*")
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        HttpSession session = request.getSession();
        String flag = (String) session.getAttribute("flag");

        if (servletPath != null && servletPath.equals("/Login/login.jsp")
                || servletPath.equals("/Login/index.jsp") || servletPath.equals("/loginContorller")) {
            chain.doFilter(req, resp);
        } else {
            if (flag != null && flag.equals("login_success")) {
                chain.doFilter(req, resp);
            } else if (flag != null && flag.equals("login_error")) {
                request.setAttribute("msg", "登陆失败,请重新登录!!!<br/>");
                RequestDispatcher rd = request.getRequestDispatcher("/Login/login.jsp");
                rd.forward(request, response);
            }else {
                request.setAttribute("msg", "您尚未登录");
                RequestDispatcher rd = request.getRequestDispatcher("/Login/login.jsp");
                rd.forward(request, response);
            }
        }
    }

    public void destroy() {

    }

}
