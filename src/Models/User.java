package Models;

import java.util.ArrayList;

public class User {


    String Username;
    String Password;
    ArrayList<String> skills;

    public String getUsername() {

        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addSkills(String skill){
        skills.add(skill);

    }
}

