import Models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ResponseHandler implements Runnable {

    private Socket remoteSocket;
    private ArrayList<User> users;
    private ArrayList<String> skillsUser1;
    private ArrayList<String> skillsUser2;
    private ArrayList<String> skillsUser3;

    public ResponseHandler(Socket remoteSocket) {
        this.remoteSocket = remoteSocket;
    }

    public void run() {
        try {

            System.out.println("Connection!");
            System.out.println("Thread count: " + Thread.activeCount());

            //Read from input stream (from client)
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(this.remoteSocket.getInputStream()));

            //Print request headers from client
            String str = ".";
            while (!str.equals("")) {
                str = inFromClient.readLine();
                //System.out.println(str);
            }

            //Create output stream (to client)
            PrintWriter outToClient = new PrintWriter(remoteSocket.getOutputStream());

            //Write response headers
            outToClient.println("HTTP/1.0 200 OK");
            outToClient.println("Content-Type: application/json");
            outToClient.println("Server: Hackerbot");
            outToClient.println("");

            users = new ArrayList<User>();
            generateUsers();
            String usersAsJson = new Gson().toJson(users);

            outToClient.println(usersAsJson);

            //Flush'n'close
            outToClient.flush();

            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generateUsers() {
        generateUserSkills();

        User user1 = new User("Jens", "Jens123", skillsUser1);
        User user2 = new User("Karl", "Karl123", skillsUser2);
        User user3 = new User("Emil", "Emil123", skillsUser3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    public void generateUserSkills() {
        skillsUser1 = new ArrayList<String>();
        skillsUser2 = new ArrayList<String>();
        skillsUser3 = new ArrayList<String>();

        skillsUser1.add("Spise");
        skillsUser2.add("Loebe");
        skillsUser3.add("Kode");
    }
}