package administrator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileUploader {
    private static final String root = "D:\\PhotoboothFileStorage";

    public static User handleRequest(HttpServletRequest req) throws Exception {
        int personNameHash = 0;
        String personName = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = upload.parseRequest(req);
            var iterator = items.iterator();
            while (iterator.hasNext()) {
                var item = (FileItem) iterator.next();
                if (item.isFormField()) {
                    personName = item.getString();
                    personNameHash = Generator.generateKey(personName);
                } else {
                    String fileName = item.getName();
                    File path = new File(root + "/" + personNameHash);
                    if (!path.exists()) {
                        boolean status = path.mkdirs();
                    }
                    File uploadedFile = new File(path + "/" + fileName);
                    System.out.println(uploadedFile.getAbsolutePath());
                    item.write(uploadedFile);
                }
            }
        }
        return new User(personName,personNameHash);
    }

}
