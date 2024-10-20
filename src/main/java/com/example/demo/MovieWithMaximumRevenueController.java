package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieWithMaximumRevenueController implements Initializable {
    @FXML
    private TableColumn<Movie, Long> budget;

    @FXML
    private TableColumn<Movie, String> genre1;

    @FXML
    private TableColumn<Movie, String> genre2;

    @FXML
    private TableColumn<Movie, String> genre3;

    @FXML
    private TableColumn<Movie, String> movieName;


    @FXML
    private TableColumn<Movie, Long> revenue;

    @FXML
    private TableView<Movie> Table;

    @FXML
    private TableColumn<Movie, Integer> time;

    @FXML
    private TableColumn<Movie, Integer> year;
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void onBackButton(ActionEvent actionEvent) throws IOException {
        main.goToSearchProductionCompaniesScene();
    }

    public Movie SearchTheMovieWithMaximumRevenue() {
        Movie temp= new Movie();
        long max = 0;
        for (int i = 0; i < Client.arr.size(); i++) {
            Movie n = Client.arr.get(i);
            if (max <n.getRevenue()) {
                max= n.getRevenue();
            }
        }
        for (int i = 0; i < Client.arr.size(); i++) {
            Movie t = Client.arr.get(i);
            if (max == t.getRevenue())
                temp= t;
        }
        return temp;
    }
    ObservableList<Movie> List1 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Movie temp1 = SearchTheMovieWithMaximumRevenue();
        List1.add(temp1);
        movieName.setCellValueFactory(new PropertyValueFactory<Movie, String>("Name"));
        year.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("ReleaseYear"));
        genre1.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre1"));
        genre2.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre2"));
        genre3.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre3"));
        time.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("RunningTime"));
        budget.setCellValueFactory(new PropertyValueFactory<Movie, Long>("Budget"));
        revenue.setCellValueFactory(new PropertyValueFactory<Movie, Long>("Revenue"));
        Table.setItems(List1);
        revenue.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        time.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre1.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre2.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre3.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        movieName.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        budget.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        year.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
    }
    public void onReloadButtonClick(ActionEvent actionEvent) {
        List1.clear();
        Movie temp1 = SearchTheMovieWithMaximumRevenue();
        List1.add(temp1);
        System.out.println(temp1.getName());
        movieName.setCellValueFactory(new PropertyValueFactory<Movie, String>("Name"));
        year.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("ReleaseYear"));
        genre1.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre1"));
        genre2.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre2"));
        genre3.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre3"));
        time.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("RunningTime"));
        budget.setCellValueFactory(new PropertyValueFactory<Movie, Long>("Budget"));
        revenue.setCellValueFactory(new PropertyValueFactory<Movie, Long>("Revenue"));
        Table.setItems(List1);
        revenue.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        time.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre1.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre2.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        genre3.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        movieName.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        budget.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
        year.setStyle("-fx-text-fill:black;" + "-fx-font-weight:bold;");
    }
}
