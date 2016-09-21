package proj.servlet;



import proj.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by SCIP on 14.08.2016.
 */
public class IndexServlet extends HttpServlet{

    private static User user;
    public static User getUser() {
        return user;
    }

    static void setUser(User user) {
        IndexServlet.user = user;
    }

    List<Objects> objectsList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(user != null){
            String test = "<a href=\"payment.jsp\">Оплата</a>\n" +
                    "    <a href=\"\">Доставка</a>\n" +
                    "    <a href=\"\">Контакти</a>\n" +
                    "    <a href=\"\">Про нас</a>\n" +
                    "    <a href=\"profile.jsp\">Welcome "+  "</a>";
            req.setAttribute("key", test);
        }else {
        String test = "<a href=\"payment.jsp\">Оплата</a>\n" +
                "    <a href=\"\">Доставка</a>\n" +
                "    <a href=\"\">Контакти</a>\n" +
                "    <a href=\"\">Про нас</a>\n" +
                "    <a href=\"\">Вхід</a>\n" +
                "    <a href=\"registration.jsp\">Реєстрація</a>" +
                " <p><p> ";
            req.setAttribute("key", test);

        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
