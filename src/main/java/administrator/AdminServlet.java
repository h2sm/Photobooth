package administrator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig
public class AdminServlet extends HttpServlet {//For Uploading files
    private final String put = "D:\\PhotoboothFileStorage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh", "5;url=http://localhost:8080/adminpanel/AdminPanel.jsp");
        //resp.sendRedirect("http://localhost:8080/adminpanel/AdminPanel.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personName = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(req);
                var iterator = items.iterator();
                while (iterator.hasNext()) {
                    var item = (FileItem) iterator.next();
                    if (item.isFormField()) {
                        personName = item.getString();
                        System.out.println(item.getString() + " isformfield");
                        item.getString();
                    }
                    else {
                        String fileName = item.getName();
                        File path = new File(put + "/" + personName);
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    }
                }
                resp.getWriter().write("Files were written successfully");
                doGet(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
