import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import Models.User;
import com.google.gson.Gson;


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

            //nyt users array af objekter med typen User
            ArrayList<User> users = new ArrayList<User>();

            //nyt array bestående af Strings
            ArrayList<String> skills = new ArrayList<String>();

            //nyt objekt af user
            User user = new User();

            //set username og password
            user.setUsername("Munne");
            user.setPassword("password");

            //add java og html/css som strings til det andet array "skills"
            skills.add("java");
            skills.add("html/css");

            //set user's egen skills array (som er tomt) lig med det skills array der er opprettet her (som ikke er tomt)
            user.setSkills(skills);


            //alt om igen
            ArrayList<String> skills2 = new ArrayList<String>();
            User user2 = new User();
            user2.setUsername("Saim");
            user2.setPassword("password");
            skills2.add("java");
            skills2.add("html/css");
            user2.setSkills(skills2);

            //tilføj user objekter til users array'et
            users.add(user);
            users.add(user2);

            //konverter users array fra java object til Json object (som er eén lang string)
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