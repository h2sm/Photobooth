package db;

import javax.sql.DataSource;

public class DBService implements DBInterface{
    private final DataSource src;
    private final DBRepository repository;

    public DBService(DataSource ds, DBRepository dbr) {
        this.src=ds;
        this.repository=dbr;
    }
    @Override
    public boolean auth(String code) {
        return false;
    }

    @Override
    public void addUser(String code) {

    }

    @Override
    public void deleteUser(String code) {

    }
}
