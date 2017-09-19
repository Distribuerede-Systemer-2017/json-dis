import com.google.gson.Gson;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ResponseHandler implements Runnable {

    private Socket remoteSocket;

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


            // Create List of users to send to client
            ArrayList<User> users = new ArrayList<User>();

            //Generate User objects
            User u1 = new User("Filip","1234");
            u1.addSkill("Java");
            u1.addSkill("CSS");

            User u2 = new User("Henrik", "4444");
            u2.addSkill("Cooking");
            u2.addSkill("Running");

            User u3 = new User("Carsten", "password");
            u3.addSkill("Word");
            u3.addSkill("Excel");
            u3.addSkill("PowerPoint");

            //Add Users to ArrayList
            users.add(u1);
            users.add(u2);
            users.add(u3);

            String usersAsJSON = new Gson().toJson(users);

            outToClient.println(usersAsJSON);

            //Flush'n'close
            outToClient.flush();

            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}