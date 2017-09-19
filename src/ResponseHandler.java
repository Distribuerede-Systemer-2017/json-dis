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
            User u1 = new User();
            u1.setUsername("martin");
            u1.setPassword("123");
            users.add(u1);
            User u2 = new User();
            u2.setUsername("pk");
            u2.setPassword("321");
            users.add(u2);
            User u3 = new User();
            u3.setUsername("toby");
            u3.setPassword("111");
            users.add(u3);
            String usersAsJson = new Gson().toJson(users);

            outToClient.println(usersAsJson);

            //Flush'n'close
            outToClient.flush();

            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}