package photobooth;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchive {
    public static byte[] makeZIP(String path) throws IOException {
        File dir = new File(path);
        File[] filesArray = dir.listFiles();
        if (filesArray == null || filesArray.length == 0)
            System.out.println(dir.getAbsolutePath() + " have no file!");
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(bo);
        for (File xlsFile : filesArray) {
            if (!xlsFile.isFile()) continue;
            ZipEntry zipEntry = new ZipEntry(xlsFile.getName());
            zipOut.putNextEntry(zipEntry);
            zipOut.write(IOUtils.toByteArray(new FileInputStream(xlsFile)));
            zipOut.closeEntry();
        }
        bo.close();
        zipOut.close();
        return bo.toByteArray();
    }
}
