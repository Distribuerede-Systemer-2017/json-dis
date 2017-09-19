package Models;


import java.util.ArrayList;

public class User {

    String username;
    String password;
    ArrayList<String> skills;

    public User(String username, String password, ArrayList<String> skills){
        this.username = username;
        this.password = password;
        this.skills = skills;
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
