

package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class AddMovieController {
    public Text text;
    public javafx.scene.control.Label Label;
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField budget;

    @FXML
    private TextField genre1;

    @FXML
    private TextField genre2;

    @FXML
    private TextField genre3;

    @FXML
    private TextField name;

    @FXML
    private TextField revenue;

    @FXML
    private TextField time;

    @FXML
    private TextField year;

    @FXML
    void onBackButton(ActionEvent event) throws IOException {
        main.goToSearchProductionCompaniesScene();
    }

    public boolean CheckName(String name) {
        int count = 0;
        for (int i = 0; i < Client.arr.size(); i++) {
            Movie q = Client.arr.get(i);
            if (name.equalsIgnoreCase(q.getName()))
                count = 1;
        }
        if (count == 1)
            return false;
        else return true;
    }

    @FXML
    void onSubmitButton(ActionEvent event) throws IOException {
        if (name.getText().isEmpty() || year.getText().isEmpty() || genre1.getText().isEmpty() || time.getText().isEmpty() || budget.getText().isEmpty() ||
                revenue.getText().isEmpty()) {
            main.canNotAddThisMovieScene();
        } else if (CheckName(name.getText())) {
            String str1 = name.getText();
            int Year = Integer.parseInt(year.getText());
            String Genre1 = genre1.getText();
            String Genre2 = genre2.getText();
            String Genre3 = genre3.getText();
            int Time = Integer.parseInt(time.getText());
            String ProName = ReadThreadClient.clientName;
            Long Budget = Long.valueOf(budget.getText());
            Long Revenue = Long.valueOf(revenue.getText());
            Movie t = new Movie(str1, Year, Genre1, Genre2, Genre3, Time, ProName, Budget, Revenue);
            ReadThreadClient.socketWrapper.write(t);
            main.addSuccessfulScene();
        } else
            main.canNotAddThisMovieScene();

        name.clear();
        year.clear();
        genre1.clear();
        genre2.clear();
        genre3.clear();
        time.clear();
        budget.clear();
        revenue.clear();
    }
}

