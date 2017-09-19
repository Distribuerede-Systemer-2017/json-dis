package Models;

import java.util.ArrayList;

public class User {

    String username, password;
    ArrayList<String> skills;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkills(String skillsToAdd) {
        skills.add(skillsToAdd);
    }
}

