package database;

import java.sql.ResultSet;

public interface DBInterface {
    boolean authenticate(int code);
    void save(String name, int code, String path);
    String loadPath(int code);
    ResultSet getAllData();
}
