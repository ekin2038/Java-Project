package PackageServer;

import com.example.demo.Movie;
import com.example.demo.MovieMessage;
import util.SocketWrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static PackageServer.Server.INPUT_FILE_NAME;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;
    public HashMap<String, SocketWrapper> clientMap;

    public ReadThreadServer(HashMap<String, SocketWrapper> map, SocketWrapper socketWrapper) {
        this.clientMap = map;
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public List<Movie> SearchByProductionCompany(String str) {
        List<Movie> temp = new ArrayList();
        for (int i = 0; i < Server.MovieList.size(); i++) {
            Movie t = Server.MovieList.get(i);
            if (t.getProductionCompany().equalsIgnoreCase(str)) {
                temp.add(t);
            }
        }
        return temp;
    }
    public void updateList() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
        for (int i = 0; i < Server.MovieList.size(); i++) {
            Movie t = Server.MovieList.get(i);
            StringBuffer pb = new StringBuffer(t.getName());
            pb.append(",");
            pb.append(String.valueOf(t.getReleaseYear()));
            pb.append(",");
            pb.append(t.getGenre1());
            pb.append(",");
            pb.append(t.getGenre2());
            pb.append(",");
            pb.append(t.getGenre2());
            pb.append(",");
            pb.append(String.valueOf(t.getRunningTime()));
            pb.append(",");
            pb.append(t.getProductionCompany());
            pb.append(",");
            pb.append(String.valueOf(t.getBudget()));
            pb.append(",");
            pb.append(String.valueOf(t.getRevenue()));
            bw.write(String.valueOf(pb));
            bw.write(System.lineSeparator());
        }
        bw.close();

    }


    @Override
    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
                if (o instanceof Movie) {
                    Movie obj = (Movie) o;
                    Server.MovieList.add(obj);
                    String from = new String();
                    from = obj.getProductionCompany();
                    List<Movie> Arr = SearchByProductionCompany(from);
                    SocketWrapper socketWrapper1 = clientMap.get(from);
                    socketWrapper1.write(Arr);
                } else if (o instanceof MovieMessage) {
                    MovieMessage obj = (MovieMessage) o;
                    Movie showing = obj.getMovie();
                    String to = new String();
                    to = obj.getTo();
                    String from = new String();
                    from = obj.getFrom();
                    Movie add = new Movie();
                    for (int i = 0; i < Server.MovieList.size(); i++) {
                        Movie n = Server.MovieList.get(i);
                        if (showing.getName().equalsIgnoreCase(n.getName())) {
                            add = n;
                            add.setProductionCompany(to);
                            Server.MovieList.remove(n);
                            Server.MovieList.add(add);
                        }
                    }
                    List<Movie> temp3 = new ArrayList<>();
                    temp3 = SearchByProductionCompany(to);
                    SocketWrapper socketWrapper1 = clientMap.get(to.toUpperCase());
                    socketWrapper1.write(temp3);
                } else if (o instanceof String) {
                    String str=(String) o;
                    clientMap.remove(str);
                }
                updateList();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
