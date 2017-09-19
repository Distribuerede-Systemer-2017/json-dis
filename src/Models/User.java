package Models;

import java.util.ArrayList;

public class User {

    String username, password;
    ArrayList<String> skills;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
