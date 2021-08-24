package administrator;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class FileManager {//это - говнокод, я просто надеюсь что когда-нибудь переделаю его...
    private static final String root = "D:\\PhotoboothFileStorage";

    public static User write(HttpServletRequest req) throws Exception {
        int personNameHash = 0;
        String personName = null;
        String pathto = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println(isMultipart + " isMultipart");
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
                        pathto = path.getAbsolutePath();
                    }
                    File uploadedFile = new File(path + "/" + fileName);
                    System.out.println(uploadedFile.getAbsolutePath());
                    item.write(uploadedFile);
                }
            }
        }
        return new User(personName,personNameHash, pathto);
    }
    @SneakyThrows
    public static void delete(int code){
        var path = Path.of(root+"\\"+code);
        System.out.println(path.toString());
        Files.walk(Path.of(root+"\\"+code))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        System.out.println("deleted");
    }

}
