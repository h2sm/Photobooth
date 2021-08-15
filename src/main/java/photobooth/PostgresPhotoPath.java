package photobooth;

import database.DBInterface;

import java.sql.SQLException;

public class PostgresPhotoPath {
    public static String getPath(DBInterface db, int userCode) throws SQLException {
        String path = "";
        var isAuth = db.authenticate(userCode);
        if (isAuth) return db.loadPath(userCode);
        else throw new SQLException("Code is not correct");
    }
}
