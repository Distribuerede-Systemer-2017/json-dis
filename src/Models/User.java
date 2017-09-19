package Models;

import java.util.ArrayList;

public class User {

    private String username, password;
    private ArrayList<User> skills;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<User> getSkills() {
        return skills;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSkills(ArrayList<User> skills) {
        this.skills = skills;
    }


}
