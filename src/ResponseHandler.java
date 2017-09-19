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

            ArrayList<User> users = new ArrayList<User>();

            User user1 = new User();
            user1.setUsername("killerxp2000");
            user1.setPassword("1234");
            user1.setSkill("fodbold");
            user1.setSkill("hockey");
            user1.setSkill("golf");

            users.add(user1);

            User user2 = new User();
            user2.setUsername("foo");
            user2.setPassword("abc");
            user2.setSkill("noget andet");

            users.add(user2);

            String jsonResponse = new Gson().toJson(users);

            outToClient.println(jsonResponse);

            //Flush'n'close
            outToClient.flush();

            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}