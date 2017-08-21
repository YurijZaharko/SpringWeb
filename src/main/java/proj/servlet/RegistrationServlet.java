package proj.servlet;



import proj.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SCIP on 14.08.2016.
 */
public class RegistrationServlet extends HttpServlet {
    private User user;
    private String name;
    private String eMail;
    private String pass;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(name != null){
            req.setAttribute("message", name);
        }

        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        name = req.getParameter("name");
//        eMail = req.getParameter("eMail");
//        pass = req.getParameter("pass");
//        user = new User(name, eMail, pass);
//        IndexServlet.setUser(user);
        resp.sendRedirect("/index");
    }
}
