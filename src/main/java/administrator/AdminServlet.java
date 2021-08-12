package administrator;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class AdminServlet extends HttpServlet {//For Uploading files

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Refresh", "5;url=http://localhost:8080/adminpanel/AdminPanel.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            var User = FileUploader.handleRequest(req);

            resp.getWriter().write("Files were written");
            doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
