

package com.example.demo;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ProductionCompanySearchingController {
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public void AllMoviesButton(ActionEvent actionEvent) throws IOException {
        main.goToProductionCompanyMoviesScene();
    }
    public void onMovieswithTheMaximumRevenueButton(ActionEvent actionEvent) throws IOException {
        main.goToMovieWithMaximumRevenueScene();
    }

    public void onTotalProfitButton(ActionEvent actionEvent) throws IOException {
        main.TotalProfitScene();
    }
    public void onTransferMovieButton(ActionEvent actionEvent) throws IOException {
        main.goToTransferMovieScene();
    }

    public void onBackToMainMenuButton(ActionEvent actionEvent) throws IOException {
        main.close();
        Client.stop.write(LogInController.FirstTimeTypedName);
        Client.stop.closeConnection();

    }

    public void onAddMovieButton(ActionEvent actionEvent) throws IOException {
        main.AddMovieScene();
    }

    public void onRecentMoviesButton(ActionEvent actionEvent) throws IOException {
        main.goToMostRecentMoviesScene();
    }
}
