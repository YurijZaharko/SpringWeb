package proj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SCIP on 14.08.2016.
 */
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = "<ul>\n" +
                "        <li>Кредит</li>\n" +
                "        <li>Наличный расчет</li>\n" +
                "    </ul>\n" +
                "    <p><a href=\"index.jsp\">На головну</a> </p>";
        String test = "tedt_test";
        req.setAttribute("massage", test);
        req.getRequestDispatcher("/payment.jsp").forward(req,resp);
    }
}
