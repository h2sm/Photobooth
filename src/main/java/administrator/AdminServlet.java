package administrator;

import database.DBFactory;
import database.DBInterface;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class AdminServlet extends HttpServlet {
    private static DBInterface db;

    @Override
    public void init() throws ServletException {
        db = DBFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Refresh", "3;url=/adminpanel/AdminPanel.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            System.out.println("kekekek");
            var type = RequestType.getRequestType(req);
            System.out.println(type);
            switch (type) {
                case DELETING -> deletePhotos(req, resp);
                case UPLOADING -> uploadPhotos(req, resp);
            }
            doGet(req, resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private void deletePhotos(HttpServletRequest req, HttpServletResponse resp) {
        int code = Integer.parseInt(req.getParameter("delete_id"));
        System.out.println(code);
        db.deletePhotos(code);
        FileManager.delete(code);
        resp.getWriter().write("Files were deleted");
    }

    private void uploadPhotos(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        var user = FileManager.write(req);
        db.save(user.getUserName(), user.getUserHashCode(), user.getPath());
        resp.getWriter().write("Files were written");
    }
}
