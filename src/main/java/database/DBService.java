package database;


import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    public DBService(DataSource ds, DBRepository dbr) {
        this.src = ds;
        this.repository = dbr;
    }

    @Override
    @SneakyThrows
    public boolean authenticate(int code) {
        boolean isAuth = false;
        var conn = src.getConnection();
        isAuth = repository.auth(code, conn);
        return isAuth;
    }

    @Override
    @SneakyThrows
    public void save(String name, int code, String path) {
        var conn = src.getConnection();
        repository.save(name, code, path, conn);
    }

    @Override
    @SneakyThrows
    public String loadPath(int code) {
        String path = null;
        var conn = src.getConnection();
        path = repository.load(code, conn);
        return path;
    }

    @Override
    @SneakyThrows
    public ResultSet getAllData() {
        var conn = src.getConnection();
        var res = repository.loadAll(conn);
        return res;
    }

    @Override
    @SneakyThrows
    public void deletePhotos(int code) {
        var conn = src.getConnection();
        repository.deletePhotos(conn,code);
    }
}
