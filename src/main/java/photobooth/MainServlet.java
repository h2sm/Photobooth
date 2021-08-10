package photobooth;

import javax.servlet.ServletException;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/photobooth")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var param = req.getParameter("first");
        var clientCode = param==null? "" : param.replaceAll("<","&lt;").replaceAll(">","&gt;");//ваиант перекрытия атаки xss
        System.out.println(clientCode);
        try {
            // TODO: 10.08.2021 - получаем код - проверяем его в базе данных - получаем соотв. путь к фотографиям - архивируем - отправляем zip
            // TODO: 10.08.2021 - написать код для добавления фотографий в систему (добавление в БД соответствия пароль-путь, добавление фото по заданному пути)
            var zip = ZipArchive.makeZIP(clientCode);
            resp.getOutputStream().write(zip);
        }
        catch (Exception e){
            resp.sendRedirect("/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
