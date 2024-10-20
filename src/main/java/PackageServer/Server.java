package PackageServer;

import com.example.demo.Movie;
import util.SocketWrapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public static List<Movie> MovieList = new ArrayList<>();
    public static final String INPUT_FILE_NAME = "movies.txt";
    private static List<String> checkProductionCompany = new ArrayList<>();


    public String clientName;
    private ServerSocket serverSocket;
    public HashMap<String, SocketWrapper> clientMap; // HashMap of client's name and socket information

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(42239);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Server accepts a client ... ");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public List<Movie> SearchByProductionCompany(List<Movie> movieList, String str) {
        List<Movie> temp = new ArrayList();
        for (int i = 0; i < movieList.size(); i++) {
            Movie t = movieList.get(i);
            if (t.getProductionCompany().equalsIgnoreCase(str)) {
                temp.add(t);
            }
        }
        return temp;
    }

    public boolean CheckName(String name) {
        int count = 0;
        for (int i = 0; i < checkProductionCompany.size(); i++) {
            if (name.equalsIgnoreCase(checkProductionCompany.get(i)))
                count = 1;
        }
        if (count == 1)
            return true;
        else return false;
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);

        socketWrapper.write(checkProductionCompany);

        clientName = (String) socketWrapper.read();

        boolean isAvailable = CheckName(clientName);

        //socketWrapper.write(isAvailable);
        //if(isAvailable){
            if(clientMap.containsKey(clientName))
                socketWrapper.write("You are logged in");
            else{
                clientMap.put(clientName, socketWrapper);
                socketWrapper.write(isAvailable);
       }
        if (isAvailable) {
            System.out.println(clientName);
            new ReadThreadServer(clientMap, socketWrapper);

            List<Movie> temp3 = new ArrayList();
            temp3 = SearchByProductionCompany(Server.MovieList, clientName);
            SocketWrapper socketWrapper1 = clientMap.get(clientName);
            socketWrapper1.write(temp3);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] out = line.split(",");
            Movie m = new Movie(out);
            MovieList.add(m);
        }
        for (int i = 0; i < MovieList.size(); i++) {
            checkProductionCompany.add(MovieList.get(i).getProductionCompany());
        }

        new Server();
    }
}
