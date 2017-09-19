import Models.Users;
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

            //Opgave 3 ArrayList
            ArrayList<Users> users = new ArrayList();

            //Tilfaeldige brugere
            ArrayList<String> user1skills = new ArrayList();
            user1skills.add("Tennis");
            user1skills.add("Markraes");
            Users user1 = new Users("Christian Mikkelsen", "1234", user1skills);

            ArrayList<String> user2skills = new ArrayList();
            user2skills.add("Promoter");
            user2skills.add("PUBG");
            Users user2 = new Users("KJ", "4321", user2skills);

            ArrayList<String> user3skills = new ArrayList();
            user3skills.add("Dancefloor");
            Users user3 = new Users("Lasse", "5678", user3skills);

            //Tilfoejer brugere til Users ArrayList
            users.add(user1);
            users.add(user2);
            users.add(user3);

            //Konversion til JSON
            String userAsJson = new Gson().toJson(users);

            outToClient.println(userAsJson);

            //Flush'n'close
            outToClient.flush();

            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}