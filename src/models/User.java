package models;

import java.util.ArrayList;

/**
 *
 * Created by Filip on 19-09-2017.
 */
public class User {

    // Parameters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }


}
