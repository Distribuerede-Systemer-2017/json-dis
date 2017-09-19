package Models;

import java.util.ArrayList;

public class User {


    String Username;
    String Password;
    ArrayList<String> skills;

    public User(){

        skills = new ArrayList<String>();
    }

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

    public void setSkills(String skills) {
        this.skills.add(skills);
    }

    public void addSkills(String skill){
        skills.add(skill);

    }
}

