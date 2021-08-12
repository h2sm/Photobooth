package db;

public interface DBInterface {
    boolean auth(String code);
    void addUser(String code);
    void deleteUser(String code);
}
