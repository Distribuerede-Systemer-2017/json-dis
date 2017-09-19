import Models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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

            ArrayList<String> user1skills = new ArrayList<String>();
            user1skills.add("Røvbanan");
            User user1 = new User("daniel","1234",user1skills);

            ArrayList<String> user2skills = new ArrayList<String>();
            user2skills.add("BeerPong");
            User user2 = new User("kaniel","1234",user2skills);

            ArrayList<String> user3skills = new ArrayList<String>();
            user3skills.add("Hurtigløb");
            User user3 = new User("taniel","1234",user3skills);

            users.add(user1);
            users.add(user2);
            users.add(user3);

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