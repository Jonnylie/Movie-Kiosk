package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ShowMoviesByYearController extends Controller<Kiosk> {

    @FXML
    private ListView<Integer> yearsLv;
    @FXML
    private TableView<Movie> moviesByYearTv;
    @FXML
    private Button button;

    public final Kiosk getKiosk() {
        return model;
    }

    private Integer getSelectedProduct() {
        return yearsLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleDisplayMovies(ActionEvent event) throws IOException {
        Integer y = getSelectedProduct();
        moviesByYearTv.setItems(getKiosk().getCatalogue().getMoviesByYear(y));

    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        stage.close();
    }

    public void initialize() {
        button.disableProperty().bind(yearsLv.getSelectionModel().selectedItemProperty().isNull());
    }

}
