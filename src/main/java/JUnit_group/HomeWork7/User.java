package JUnit_group.HomeWork7;

import java.time.LocalDate;

public class User extends Person{
    private String login;
    private String password;
    private String eMail;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public User(String firstName, String lastName, LocalDate dateOfBirth, int age, String login, String password, String eMail) {
        super(firstName, lastName, dateOfBirth, age);
        this.login = login;
        this.password = password;
        this.eMail = eMail;
    }
    public void printUserInfo()
    {
        System.out.println("Print User Info");
        this.toString();
    }
}
