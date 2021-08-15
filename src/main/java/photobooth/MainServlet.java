package photobooth;

import database.DBFactory;
import database.DBInterface;
import lombok.SneakyThrows;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/photobooth")
public class MainServlet extends HttpServlet {
    private static DBInterface db;

    @Override
    public void init() throws ServletException {
        db = DBFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var param = req.getParameter("first");
        var clientCode = param == null ? "" : param.replaceAll("<", "&lt;").replaceAll(">", "&gt;");//ваиант перекрытия атаки xss (посоветовали умные дяди ашто?)
        System.out.println(clientCode);
        try {
            var code = Integer.parseInt(clientCode);
            var path = PostgresPhotoPath.getPath(db, code);
            var zip = ZipArchive.makeZIP(path);
            resp.getOutputStream().write(zip);
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }


}
