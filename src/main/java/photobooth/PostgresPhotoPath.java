package photobooth;

import database.DBInterface;

import java.sql.SQLException;

public class PostgresPhotoPath {
    public static String getPath(DBInterface db, int userCode) throws SQLException {
        var isAuth = db.authenticate(userCode);
        if (isAuth) {
            var path = db.loadPath(userCode);
            System.out.println(isAuth + " " + path);
            return path;
        } else throw new SQLException("Code is not correct");
    }
}
