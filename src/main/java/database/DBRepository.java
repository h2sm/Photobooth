package database;

import java.sql.Connection;
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
        try (var ps = conn.prepareStatement("insert into photouser values ( ?, ?, ?, false)")){
            if (name.toLowerCase().contains("insert")) throw new SQLException("Cant allow this"); //НЕТ
            ps.setString(1,name);
            ps.setInt(2,code);
            ps.setString(3,path);
            ps.execute();
        }
    }

    public String load(int code, Connection conn) throws SQLException {
        String path = "";
        try (var ps = conn.prepareStatement("select pathto from photouser where code = ?")){
            ps.setInt(1, code);
            var result = ps.executeQuery();
            while (result.next()) path = result.getString("pathto");
        }
        return path;
    }
}
