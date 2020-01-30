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

public class ShowMoviesByGenreController extends Controller<Kiosk> {

    @FXML
    private ListView<Genre> genresLv;
    @FXML
    private TableView<Movie> moviesInGenreTv;
    @FXML
    private Button button;

    public final Kiosk getKiosk() {
        return model;
    }

    private Genre getSelectedProduct() {
        return genresLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleDisplayMovies(ActionEvent event) throws IOException {
        Genre g = getSelectedProduct();

        moviesInGenreTv.setItems(getKiosk().getCatalogue().getMoviesInGenre(g));

    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        stage.close();
    }

    public void initialize() {
        button.disableProperty().bind(genresLv.getSelectionModel().selectedItemProperty().isNull());
    }

}
