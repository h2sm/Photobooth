package administrator;

public class User {
    private int userHashCode = 0;
    private String userName;
    private String path;

    public User(String name, int hash, String path){
        this.userName = name;
        this.userHashCode = hash;
        this.path = path;
    }

    public int getUserHashCode() {
        return userHashCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPath() {
        return path;
    }
}
