package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfitController implements Initializable {
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Text Output;

    public long SearchTotalProfit() {
        long[] TotalProfit = new long[Client.arr.size()];
        int p=0;
        for (int i = 0; i < Client.arr.size(); i++) {
            Movie t = Client.arr.get(i);
            TotalProfit[p] = t.getRevenue() - t.getBudget();
            p++;
        }
        long sum = 0;
        for (int i = 0; i < TotalProfit.length; i++)
            sum = sum + TotalProfit[i];

        return sum;
    }


    public void onBackButton(ActionEvent actionEvent) throws IOException {
        main.goToSearchProductionCompaniesScene();
    }
    public void onReloadButtonClick(ActionEvent actionEvent) {
        long sum = SearchTotalProfit();
        Output.setText( "$ "+ String.valueOf(sum));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        long sum = SearchTotalProfit();
        Output.setText( "$ "+ String.valueOf(sum));
    }
}

