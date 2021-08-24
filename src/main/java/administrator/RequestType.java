package administrator;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpRetryException;

public enum RequestType {
    UPLOADING, DELETING;
    public static RequestType getRequestType(HttpServletRequest req) throws Exception {
        if (ServletFileUpload.isMultipartContent(req)) return RequestType.UPLOADING;
        else if (req.getParameter("delete_id")!=null)return RequestType.DELETING;
        else throw new Exception("no Matching types of requestYpe");
    }
}
