package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class FavouriteMoviesController extends Controller<Kiosk> {

    @FXML
    private TableView<Movie> moviesTv;
    @FXML
    private TextField idTf;
    @FXML
    private Button selectTf;
    @FXML
    private Text favouriteTf;

    public void initialize() {
        selectTf.disableProperty().bind(idTf.textProperty().isEmpty());
    }

    private int ID() {
        String text = idTf.getText();
        int ID = Integer.parseInt(text);
        return ID;

    }

    private Customer getID() {
        return getKiosk().getCatalogue().getCustomer(ID());
    }

    public final Kiosk getKiosk() {
        return model;
    }

    public void handleSelectCustomer(ActionEvent event) throws IOException {
        try {
            Customer c = model.getCustomer(ID());
            if (c != null) {
                favouriteTf.setText(getID() + "");
                moviesTv.setItems(getKiosk().getCustomer(ID()).favouriteMovies());

            } else {
                favouriteTf.setText("No such account.");
                moviesTv.setItems(null);
            }
        } catch (Exception ex) {

            favouriteTf.setText("ID that you've entered is not a number");
            moviesTv.setItems(null);

        }
    }

    public void handleClose(ActionEvent event) {
        stage.close();
    }

}
