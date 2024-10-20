package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController {
    public javafx.scene.control.Label Label;
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public TextField EnteredProductionCompany;
    public static String FirstTimeTypedName;

    public void onLogInButton(ActionEvent actionEvent) throws IOException {
        String o= EnteredProductionCompany.getText();
        Client.Name=o;
        String obj=o.toUpperCase();
        FirstTimeTypedName=obj;

        System.out.println(FirstTimeTypedName);
        String serverAddress = "127.0.0.1";
        int serverPort = 42239;
        new Client(serverAddress, serverPort, obj, main);
    }
}
