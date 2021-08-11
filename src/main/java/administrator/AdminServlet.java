package administrator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh", "5;url=http://localhost:8080/adminpanel/AdminPanel.jsp");
        //resp.sendRedirect("http://localhost:8080/adminpanel/AdminPanel.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var str = req.getParameter("personName");
        System.out.println(str);
        resp.getWriter().write("Логин для входа: " + str);
        doGet(req, resp);
    }
}
