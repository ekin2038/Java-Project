package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage stage;
    //public static Main m;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        LogInController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Log In Menu");
        stage.setScene(scene);
        stage.show();
    }
    public void goToSearchProductionCompaniesScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ProductionCompanySearching.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        ProductionCompanySearchingController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }

    public void goToProductionCompanyMoviesScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ProductionCompanyMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        ProductionCompanyMoviesController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void goToTransferMovieScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TransferMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        TransferMovieController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void AddMovieScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 798, 574);
        AddMovieController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void goToMovieWithMaximumRevenueScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MovieWithMaximumRevenue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        MovieWithMaximumRevenueController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void goToMostRecentMoviesScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MostRecentMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 609);
        MostRecentMoviesController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void TotalProfitScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TotalProfit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        TotalProfitController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle(LogInController.FirstTimeTypedName);
        stage.setScene(scene);
        stage.show();
    }
    public void canNotAddThisMovieScene() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Can'tAddMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 405, 178);
        CanTAddMovie controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle("ERROR!!!");
        stage.setScene(scene);
        stage.show();
    }
    public void LogInErrorScene() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogInError.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 145);
        LogInError controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle("ERROR!!!");
        stage.setScene(scene);
        stage.show();
    }
    public void canTtransferScene() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("canTtransfer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 397, 219);
        CanTtransfer controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle("ERROR!!!");
        stage.setScene(scene);
        stage.show();
    }
    public void addSuccessfulScene() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddSuccessful.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 322, 145);
        AddSuccessful controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle(" ");
        stage.setScene(scene);
        stage.show();
    }
    public void TransferSuccessfulScene() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TransferSuccesful.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 434, 208);
        TransferSuccesful controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle(" ");
        stage.setScene(scene);
        stage.show();
    }
    public void YouAreLoggedIn() throws IOException {
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoggedIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 448, 243);
        LoggedIn controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setStage(stage);
        stage.setTitle(" ");
        stage.setScene(scene);
        stage.show();
    }
    public void close(){
        stage.close();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}