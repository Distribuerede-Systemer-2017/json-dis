package Models;

import java.util.ArrayList;

public class User {
    String username;
    String password;

    ArrayList<String> skills;

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void addSkills(String skill) {
        skills.add(skill);
    }

    public java.util.ArrayList<String> getSkills() {
        return skills;
    }
}
