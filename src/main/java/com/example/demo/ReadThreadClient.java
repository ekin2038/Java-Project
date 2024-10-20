package com.example.demo;

import util.SocketWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient implements Runnable {
    Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private Thread thr;
    public static SocketWrapper socketWrapper;
    public static String clientName;
    List<Movie> collection = new ArrayList<>();

    public ReadThreadClient(SocketWrapper socketWrapper, String name) {
        this.socketWrapper = socketWrapper;
        this.clientName = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {

        try {
            while (true) {
                Object o = socketWrapper.read();
                if (o instanceof ArrayList) {
                    collection = (ArrayList) o;
                    Client.arr = new ArrayList<>();
                    for (int i = 0; i < collection.size(); i++) {
                        Movie n = collection.get(i);
                        Client.arr.add(n);
                    }
                }

                /*

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(count==1) {
                            try {



                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (count==2) {


                        }
                        else if(count==3){

                        }
                    }
                }); */
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



