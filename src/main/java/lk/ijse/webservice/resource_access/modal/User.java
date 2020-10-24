package lk.ijse.webservice.resource_access.modal;

public class User {
    private int id;
    private  String username;
    private  String time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User() {
    }

    public User(int id, String username, String time) {
        this.id = id;
        this.username = username;
        this.time = time;
    }
}
