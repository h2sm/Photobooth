package database;

public interface DBInterface {
    boolean authenticate(int code);
    void save(String name, int code, String path);
    String loadPath(int code);
}
