package administrator;

public class User {
    private int userHashCode = 0;
    private String userName;

    public User(String name, int hash){
        this.userName = name;
        this.userHashCode = hash;
    }

    public int getUserHashCode() {
        return userHashCode;
    }

    public String getUserName() {
        return userName;
    }
}
