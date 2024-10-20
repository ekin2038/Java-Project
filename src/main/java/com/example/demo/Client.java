package com.example.demo;

import javafx.application.Platform;
import util.SocketWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }


    public static List<Movie> arr;
    public static List<String> ProNames;
    public static SocketWrapper stop;
    public static String Name;

    public Client(String serverAddress, int serverPort, String name, Main main) {
        try {
            String clientName = name;
            this.main = main;
            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);
            stop = socketWrapper;

            Object ob = socketWrapper.read();
            if (ob instanceof ArrayList) {
                List<String> testing = (ArrayList) ob;
                ProNames = new ArrayList<>();
                ProNames = testing;
            }

            socketWrapper.write(clientName);
            Object o = socketWrapper.read();
            if (o instanceof Boolean) {
                boolean obj = (boolean) o;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (obj) {
                            try {
                                main.goToSearchProductionCompaniesScene();
                                new ReadThreadClient(socketWrapper, clientName);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            try {
                                stop.closeConnection();
                                main.LogInErrorScene();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

            }
            if(o instanceof String){
                String str=(String) o;
                if(str.equalsIgnoreCase("You are logged in"))
                    main.YouAreLoggedIn();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

