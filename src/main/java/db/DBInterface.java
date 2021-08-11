package db;

public interface DBInterface {
    boolean auth(String code);
    void generateUser(String name);//генерация по солям ыыыы
    void deleteUser(String code);
}
