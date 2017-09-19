package Models;

import java.util.ArrayList;

public class User {

    String username;
    String password;
    ArrayList<String> skills;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;

        this.skills = new ArrayList<String>();
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

}


