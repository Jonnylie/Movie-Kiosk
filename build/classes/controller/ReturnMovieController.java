package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ReturnMovieController extends Controller<Kiosk> {

    @FXML
    private TableView<Movie> rentedMoviesTv;
    @FXML
    private TextField idTf;
    @FXML
    private Text movieReturnedTf;
    @FXML
    private Button selectTf;
    @FXML
    private Button returnTf;

    public void initialize() {

        selectTf.disableProperty().bind(idTf.textProperty().isEmpty());
        returnTf.disableProperty().bind(rentedMoviesTv.getSelectionModel().selectedItemProperty().isNull());

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

    private Movie getSelectedProduct() {
        return rentedMoviesTv.getSelectionModel().getSelectedItem();
    }

    public void handleReturnSelectedMovie(ActionEvent event) {
        Movie m = getSelectedProduct();
        getKiosk().getCatalogue().returnMovieFromCustomer(m, getID());
        movieReturnedTf.setText("Movie Returned.");
    }

    public void handleSelectCustomer(ActionEvent event) throws IOException {
        try {
        Customer c = model.getCustomer(ID());
            if (c != null) {
                rentedMoviesTv.setItems(getKiosk().getCustomer(ID()).currentlyRented());
                movieReturnedTf.setText("");
            } else {
                movieReturnedTf.setText("Customer does not exist.");
                rentedMoviesTv.setItems(null);
            }
        } catch (Exception ex) {
            movieReturnedTf.setText("ID that you've entered is not a number");
            rentedMoviesTv.setItems(null);
        }

    }

    public void handleClose(ActionEvent event) {
        stage.close();
    }

}
