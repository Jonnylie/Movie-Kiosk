package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RemoveMovieController extends Controller<Kiosk> {

    @FXML
    private TableView<Movie> moviesTv;
    @FXML
    private Button button;

    public void initialize() {
        button.disableProperty().bind(moviesTv.getSelectionModel().selectedItemProperty().isNull());
    }

    public final Kiosk getKiosk() {
        return model;
    }

    private Movie getSelectedProduct() {
        return moviesTv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleRemoveMovie(ActionEvent event) throws IOException {
        Movie m = getSelectedProduct();
        getKiosk().getCatalogue().removeMovie(m);

    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        stage.close();
    }

}
