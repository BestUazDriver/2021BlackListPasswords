package models;

public class User {
    private String eMail;
    private String password;

    public User(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
