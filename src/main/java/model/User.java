package model;

public class User {
    private int id;
    private String name;
    private String birthday;
    private int passportNumber;
    private String role;

    public User(int id, String name, String birthday, int passportNumber, String role) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}