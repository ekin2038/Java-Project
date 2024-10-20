package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TransferMovieController implements Initializable{
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private ChoiceBox<String> Moviename;

    @FXML
    private ChoiceBox<String> To;

    @FXML
    void onTransferButtonClick(ActionEvent event) {
        String from= ReadThreadClient.clientName;
        String to= To.getValue();
        String MovieName= Moviename.getValue();
        Movie remove= new Movie();
        for(int i=0; i<Client.arr.size();i++){
            Movie n= Client.arr.get(i);
            if(n.getName().equalsIgnoreCase(MovieName)){
                remove =n;
                Client.arr.remove(n);
            }
        }
        MovieMessage movieMessage= new MovieMessage();
        movieMessage.setFrom(from);
        movieMessage.setTo(to);
        movieMessage.setMovie(remove);
        new WriteThreadClient(ReadThreadClient.socketWrapper, movieMessage);
        try {
            main.TransferSuccessfulScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     public void onReloadButtonClick(ActionEvent actionEvent){
         try {
             main.goToTransferMovieScene();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        main.goToSearchProductionCompaniesScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Client.ProNames.size());
        for(int i=0; i<Client.arr.size(); i++){
            Movie t= Client.arr.get(i);
            Moviename.getItems().add(t.getName());
        }
        Set<String> temp= new HashSet<>(Client.ProNames);
        temp.remove(ReadThreadClient.clientName);
        for(String str: temp) {
            To.getItems().add(str);
            System.out.println(str);
        }
    }

}
