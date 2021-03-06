package database;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRepository {

    public boolean auth(int usercode, Connection conn) throws SQLException {
        boolean isAuth = false;
        try (var ps = conn.prepareStatement("select exists(select 1 from photouser where code = ?) AS \"exists\" ")) {
            ps.setInt(1, usercode);
            var res = ps.executeQuery();
            while (res.next()) isAuth = res.getBoolean("exists");
            System.out.println(isAuth);
        }
        return isAuth;
    }

    public void save(String name, int code, String path, Connection conn) throws SQLException {
        try (var ps = conn.prepareStatement("insert into photouser values ( ?, ?, ?, false)")) {
            if (name.toLowerCase().contains("insert")) throw new SQLException("Cant allow this"); //НЕТ
            ps.setString(1, name);
            ps.setInt(2, code);
            ps.setString(3, path);
            ps.execute();
        }
    }

    public String load(int code, Connection conn) throws SQLException {
        String path = "";
        try (var ps = conn.prepareStatement("select pathto from photouser where code = ?")) {
            ps.setInt(1, code);
            var result = ps.executeQuery();
            while (result.next()) path = result.getString("pathto");
        }
        return path;
    }

    @SneakyThrows
    public ResultSet loadAll(Connection conn) throws SQLException {
        var ps = conn.prepareStatement("select * from photouser");
        ResultSet res = ps.executeQuery();
        return res;
    }

    public void deletePhotos(Connection conn, int code) throws SQLException {
        var ps = conn.prepareStatement("delete from photouser where code = ?");
        ps.setInt(1, code);
        ps.executeUpdate();
    }
    public void setDownloaded(Connection conn, int code) throws SQLException{
        try (var ps = conn.prepareStatement("UPDATE photouser SET hasdownloaded = ? WHERE code = ?;")){
            ps.setBoolean(1, true);
            ps.setInt(2,code);
            var upd = ps.executeUpdate();
            System.out.println(upd + " rows affected");
        }
    }
}
